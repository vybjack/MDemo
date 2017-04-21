package loovee.com.mddemo.ui.home;

import android.widget.TextView;

import butterknife.Bind;
import loovee.com.mddemo.R;
import loovee.com.mddemo.ui.base.BaseActivity;

public class HomeActivity extends BaseActivity<HomePresenter, HomeModel> implements HomeMVP.View {

    @Bind(R.id.text)
    TextView text;

    @Override
    public int setContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {

    }

    @Override
    public void showHomeData(String result) {
        text.setText(result);



    }

}
