package com.ifading.babynote;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifading.babynote.Constant.LoginConstant;
import com.ifading.babynote.activity.LoginActivity;
import com.ifading.babynote.fragment.MeFragment;
import com.ifading.babynote.fragment.RecordFragment;
import com.ifading.babynote.fragment.StatisticFragment;
import com.ifading.common.app.AppContextUtils;
import com.ifading.common.data.PreferenceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    @BindView(R.id.main_tbl)
    protected TabLayout mTabLayout;
    @BindView(R.id.main_vp)
    protected ViewPager mViewPager;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    private String[] mTitles = {"记录", "统计", "我"};
    private int[] mUnselectImgs = {R.drawable.record_unselect, R.drawable.statistic_unselect, R.drawable.me_unselect};
    private int[] mSelectImgs = {R.drawable.record_select, R.drawable.statistic_select, R.drawable.me_select};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppContextUtils.init(this.getApplication());
        ButterKnife.bind(this);

        initView();
        initEvent();
        initData();
    }

    private void initView() {
        //给TabLayout设置关联ViewPager，如果设置了ViewPager，那么ViewPagerAdapter中的getPageTitle()方法返回的就是Tab上的标题
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(3);
        MainViewPager viewPagerAdapter = new MainViewPager(getSupportFragmentManager());
        RecordFragment imageFragment = RecordFragment.newInstance(0);
        StatisticFragment mCoinFragment = StatisticFragment.newInstance(1);
        MeFragment mNewsFragment = MeFragment.newInstance(2);
        viewPagerAdapter.addFragment(mCoinFragment, "记录");
        viewPagerAdapter.addFragment(imageFragment, "统计");
        viewPagerAdapter.addFragment(mNewsFragment, "我");
        mViewPager.setAdapter(viewPagerAdapter);
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        one.setIcon(R.drawable.record_unselect);
        two.setIcon(R.drawable.statistic_unselect);
        three.setIcon(R.drawable.me_unselect);
        for (int i = 0; i < viewPagerAdapter.getCount(); i++) {
            //获得到对应位置的Tab
            TabLayout.Tab itemTab = mTabLayout.getTabAt(i);
            if (itemTab != null) {
                //设置自定义的标题
                itemTab.setCustomView(R.layout.item_tab);
                TextView textView = (TextView) itemTab.getCustomView().findViewById(R.id.tv_tab_name);
                textView.setTextColor(i == 0 ? Color.GREEN : Color.GRAY);
                textView.setText(mTitles[i]);
                ImageView imageView = (ImageView) itemTab.getCustomView().findViewById(R.id.iv_tab_ico);
                imageView.setImageResource(i == 0 ? mSelectImgs[0] : mUnselectImgs[i]);
            }
        }
        //mTabLayout.getTabAt(0).getCustomView().setSelected(true);
        //mViewPager.setCurrentItem(0);
    }

    private void initEvent() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                TextView tv = (TextView) tab.getCustomView().findViewById(R.id.tv_tab_name);
                tv.setTextColor(Color.GREEN);
                ImageView iv = (ImageView) tab.getCustomView().findViewById(R.id.iv_tab_ico);

                iv.setImageResource(mSelectImgs[tab.getPosition()]);
                getSupportActionBar().setTitle(mTitles[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView tv = (TextView) tab.getCustomView().findViewById(R.id.tv_tab_name);
                tv.setTextColor(Color.GRAY);
                ImageView iv = (ImageView) tab.getCustomView().findViewById(R.id.iv_tab_ico);

                iv.setImageResource(mUnselectImgs[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initData() {
        String username = PreferenceUtils.getString(AppContextUtils.getBaseContext(), LoginConstant.USER_NAME);
        String password = PreferenceUtils.getString(AppContextUtils.getBaseContext(), LoginConstant.USER_NAME);
        if (username == null || password == null) {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
