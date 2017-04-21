package loovee.com.mddemo.ui.main.ZhiHuDetail;

import android.graphics.Rect;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.Bind;
import loovee.com.mddemo.R;
import loovee.com.mddemo.entity.ZhiHuDetailEntity;
import loovee.com.mddemo.ui.base.BaseActivity;
import loovee.com.mddemo.util.ImageUtil;

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
