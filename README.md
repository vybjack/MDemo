# MDemo
基于 MVP 模式的知乎新闻阅读，包含 MD 风格

#### 首先抽象出基类 BasePresenter BaseModel BaseView
```
public abstract class BasePresenter<V,M> implements BaseCallBack{

    protected Context mContext;
    protected V mView;
    protected M mModule;

    public void setVM(Context context, V v, M m){
        this.mContext = context;
        this.mView = v;
        this.mModule = m;
    }

    public abstract void initRequest();//一开始需要请求的数据

}
```
```
public abstract class BaseModel {

    protected BaseCallBack callBack;//数据回调给 Presenter 的接口

    public void setOnResultCallBack(BaseCallBack callBack) {
        this.callBack = callBack;
    }
}
```
```
public interface BaseView {
    //这里可以作为预留
}
```
#### 编写 BaseActivity 代码，将 View Model 和 Presenter 联系起来
```
public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    protected P mPresenter;
    protected M mModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        ButterKnife.bind(this);
        mPresenter = InstanceUtil.getInstance(this,0);//泛型的实例化
        mModule = InstanceUtil.getInstance(this,1);//泛型的实例化
        if(this instanceof BaseView){
            if(mModule != null){
                mModule.setOnResultCallBack(mPresenter);//设置数据回调方法
            }
            if(mPresenter != null){
                mPresenter.setVM(this,this,mModule);//建立 View 与 Model 之间的联系
                mPresenter.initRequest();//初始化数据请求
            }
        }
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public abstract int setContentView();
    public abstract void initData();

}
```
#### 编写具体业务代码，以 ZhiHuDetail模块 为例
此模块工程结构：
![](images/zhihudetail.png)
```
ZhiHuDetailMVP 代码示例：
public interface ZhiHuDetailMVP {//包含对应模块的 View Model Presenter 

    interface View extends BaseView{
        void showListData(ZhiHuDetailEntity entity);
    }

    abstract class Model extends BaseModel{
        //请求网络列表数据
        abstract void requestListData(String date);
    }

    abstract class Presenter extends BasePresenter<View,Model>{

        //通知 model 请求列表数据
        public abstract void askModelRequestListData(String date);

    }
}
```
```
ZhiHuDetailPresenter 代码示例：
public class ZhiHuDetailPresenter extends ZhiHuDetailMVP.Presenter {//

    @Override
    public void askModelRequestListData(String date) {
        mModule.requestListData(date);
    }

    @Override
    public void initRequest() {
    }

    @Override
    public void onResult(String result, int code) {
        ZhiHuDetailEntity entity = new Gson().fromJson(result,ZhiHuDetailEntity.class);
        mView.showListData(entity);
    }
}
```
```
ZhiHuDetailModel 代码示例：
public class ZhiHuDetailModel extends ZhiHuDetailMVP.Model {

    public static String ZHI_HU_BASE_USL = "http://news-at.zhihu.com/api/4/news/";

    @Override
    public void requestListData(String date) {
        String url = ZHI_HU_BASE_USL + date;
        LooveeRequestParams params = new LooveeRequestParams(url);
        LooveeHttp.createHttp().get(params, String.class, new OnLooveeResponseListener<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSucceed(LooveeResponse<String> response) {
                if(callBack != null){
                    String result = response.get();
                    callBack.onResult(result,1000);
                    Log.e("数据列表：",result);
                }
            }

            @Override
            public void onFailed(Exception exception, int responseCode) {

            }

            @Override
            public void onFinish() {

            }
        });
    }

}

```
```
ZhiHuDetailActivity 代码示例：
public class ZhiHuDetailActivity extends BaseActivity<ZhiHuDetailPresenter, ZhiHuDetailModel> implements ZhiHuDetailMVP.View {

    public static String ID = "id";
    @Bind(R.id.back_drop)
    ImageView backDrop;
    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    @Bind(R.id.zhi_hu_detail_webView)
    WebView zhiHuDetailWebView;

    @Override
    public int setContentView() {
        return R.layout.activity_zhi_hu_detail;
    }

    @Override
    public void initData() {
        setSupportActionBar(toolBar);

        String id = getIntent().getStringExtra(ID);
        mPresenter.askModelRequestListData(id);
    }

    @Override
    public void showListData(ZhiHuDetailEntity entity) {
        ImageUtil.loadImg(this,backDrop,entity.getImage());

        zhiHuDetailWebView.getSettings().setDefaultTextEncodingName("UTF-8");//设置默认为utf-8
        zhiHuDetailWebView.setWebViewClient(new WebViewClient());
        zhiHuDetailWebView.loadData(entity.getBody(),"text/html;charset=UTF-8",null);
    }

}
```
