package loovee.com.mddemo.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import loovee.com.mddemo.R;
import loovee.com.mddemo.ui.base.BaseActivity;
import loovee.com.mddemo.ui.main.looklook.LookLookFragment;
import loovee.com.mddemo.ui.main.wangyi.WangYiFragment;
import loovee.com.mddemo.ui.main.zhihu.ZhiHuFragment;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayoutView)
    TabLayout tabLayoutView;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.navigationView)
    NavigationView navigationView;
    @Bind(R.id.drawerLayoutView)
    DrawerLayout drawerLayoutView;

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        drawerLayoutView.openDrawer(navigationView);

        String[] titles = new String[]{"知乎","网易","随便看看"};

        tabLayoutView.addTab(tabLayoutView.newTab().setText("知乎"));
        tabLayoutView.addTab(tabLayoutView.newTab().setText("网易"));
        tabLayoutView.addTab(tabLayoutView.newTab().setText("随便看看"));

        tabLayoutView.setupWithViewPager(viewPager);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ZhiHuFragment());
        fragments.add(new WangYiFragment());
        fragments.add(new LookLookFragment());

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments,titles));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.zhi_hu:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.wang_yi:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.look_per_day:
                        viewPager.setCurrentItem(2);
                        break;
                }
                drawerLayoutView.closeDrawer(navigationView);
                return false;
            }
        });

    }

}
