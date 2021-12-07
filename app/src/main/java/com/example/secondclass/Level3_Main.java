package com.example.secondclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class Level3_Main extends AppCompatActivity implements View.OnClickListener {
    private TextView title,context;
    private ViewPager2 viewPager2;
    private Level3 oneFragment;
    private TwoFragment twoFragment;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    //    private FragmentAdapter mFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initViews();
//        setContentView(R.layout.main);
//        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(),mFragmentList);
//        vp2.setAdapter(mFragmentAdapter);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initViews();


        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(oneFragment);
        fragments.add(twoFragment);
        PagerAdapter adapter = new PagerAdapter(this,fragments);
        viewPager2.setAdapter(adapter);
        viewPager2.setOffscreenPageLimit(1);
    }

    @Override
    public void onClick(View v) {

    }

    private void initViews() {
        viewPager2 = findViewById(R.id.pager);
        oneFragment = new Level3();
        twoFragment = new TwoFragment();
        //给FragmentList添加数据
        mFragmentList.add(oneFragment);
        mFragmentList.add(twoFragment);
    }
//
//
//
//    public class FragmentAdapter extends FragmentPagerAdapter {
//
//        List<Fragment> fragmentList = new ArrayList<Fragment>();
//
//        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
//            super(fm);
//            this.fragmentList = fragmentList;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return fragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragmentList.size();
//        }
//
//    }

}
//
//package com.example.secondclass;
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.viewpager2.adapter.FragmentStateAdapter;
//import androidx.viewpager2.widget.ViewPager2;
//
//import java.util.ArrayList;
//import java.util.List;
//
////public class Level3_Main extends AppCompatActivity implements View.OnClickListener{
//    public class Level3_Main extends FragmentActivity {
//        private static final int NUM_PAGES = 2;
//        private ViewPager2 viewPager;
//        private FragmentStateAdapter pagerAdapter;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_level3_main);
//            viewPager = findViewById(R.id.pager);
//            pagerAdapter = new ScreenSlidePagerAdapter(this);
//            viewPager.setAdapter(pagerAdapter);
//        }
//
//        @Override
//        public void onBackPressed() {
//            if (viewPager.getCurrentItem() == 0) {
//                super.onBackPressed();
//            } else {
//                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
//            }
//        }
//
//        private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
//            public ScreenSlidePagerAdapter(FragmentActivity fa) {
//                super(fa);
//            }
//
//            @Override
//            public Fragment createFragment(int position) {
//                return new Level3();
//            }
//
//            @Override
//            public int getItemCount() {
//                return NUM_PAGES;
//            }
//        }
//    }
////    ViewPager2 mVp2;
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_level3_main);
////        init();
////    }
////
////    private void init() {
////        List<Fragment> lists = new ArrayList<>();
////        lists.add(Level3.newInstance());
////        mVp2 = findViewById(R.id.vp2);
////        mVp2.setAdapter(new MyAdapterLevel3(getSupportFragmentManager(),getLifecycle(),lists));
////        mVp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
////            @Override
////            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
////            }
////
////            @Override
////            public void onPageSelected(int position) {
////                super.onPageSelected(position);
//////                changeTab(position);
////            }
////
////            @Override
////            public void onPageScrollStateChanged(int state) {
////                super.onPageScrollStateChanged(state);
////            }
////        });
////    }
////
////    @Override
////    public void onClick(View v) {
////
////    }
////}
