package com.lrony.mvideo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.lrony.mvideo.adapter.MainFragmentAdapter;
import com.lrony.mvideo.base.BaseActivity;
import com.lrony.mvideo.fragment.ImageFragment;
import com.lrony.mvideo.fragment.LikeFragment;
import com.lrony.mvideo.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private static final String TAG = "MainActivity";

    private BottomNavigationBar navigationBar;
    private ViewPager viewPager;

    private MainFragmentAdapter mainFragmentAdapter;
    private FragmentManager fragmentManager;

    List<Fragment> mFragmentList = new ArrayList<Fragment>();

    private static final int ITEM_0 = 0;
    private static final int ITEM_1 = 1;
    private static final int ITEM_2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initNavigationBar();
        initListener();
    }

    private void initView() {
        navigationBar = findViewById(R.id.bottom_navigation_bar);
        viewPager = findViewById(R.id.viewPager);
        fragmentManager = getSupportFragmentManager();
        initFragmetList();
        mainFragmentAdapter = new MainFragmentAdapter(fragmentManager, mFragmentList);
        viewPager.setAdapter(mainFragmentAdapter);
        viewPager.setCurrentItem(ITEM_0);
    }

    private void initFragmetList() {
        Fragment videoView = new VideoFragment();
        Fragment imageView = new ImageFragment();
        Fragment likeView = new LikeFragment();
        mFragmentList.add(videoView);
        mFragmentList.add(imageView);
        mFragmentList.add(likeView);
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(this);
    }

    private void initNavigationBar() {
        navigationBar.setTabSelectedListener(this);
        navigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        navigationBar.setBarBackgroundColor(R.color.white);
        navigationBar.setInActiveColor(R.color.gray_8f);
        navigationBar.setActiveColor(R.color.colorPrimary);
        BottomNavigationItem item1 = new BottomNavigationItem(R.drawable.ic_man, "Main");
        BottomNavigationItem item2 = new BottomNavigationItem(R.drawable.ic_woman, "WoMain");
        BottomNavigationItem item3 = new BottomNavigationItem(R.drawable.ic_me, "Me");
        navigationBar
                .addItem(item1)
                .addItem(item2)
                .addItem(item3)
                .setFirstSelectedPosition(0)
                .initialise(); //所有的设置需在调用该方法前完成
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case ITEM_0:
                viewPager.setCurrentItem(ITEM_0);
                break;
            case ITEM_1:
                viewPager.setCurrentItem(ITEM_1);
                break;
            case ITEM_2:
                viewPager.setCurrentItem(ITEM_2);
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        navigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
