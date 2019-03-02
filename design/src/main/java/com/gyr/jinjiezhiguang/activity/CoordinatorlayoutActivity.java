package com.gyr.jinjiezhiguang.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gyr.jinjiezhiguang.R;
import com.gyr.jinjiezhiguang.adapter.FragmentAdapter;
import com.gyr.jinjiezhiguang.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorlayoutActivity extends AppCompatActivity {
private TabLayout mTabLayout;
private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout);
        mViewPager=findViewById(R.id.viewpager);
        initViewPager();
    }

    private void initViewPager(){
        mTabLayout=findViewById(R.id.tabs);
        List<String> titles=new ArrayList<>();
        titles.add("精选");
        titles.add("体育啊的");
        titles.add("巴萨啊");
        titles.add("购物");
        titles.add("明星");
        titles.add("视频");
        titles.add("健康");
        titles.add("励志");
        titles.add("图文");
        titles.add("本地");
        titles.add("动漫");
        titles.add("搞笑");
        titles.add("精选");
        List<Fragment> mFragments=new ArrayList<>();
        for(int i=0;i<titles.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
            mFragments.add(new ListFragment());
        }
        FragmentAdapter mFragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),mFragments,titles);
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapter);
    }
}
