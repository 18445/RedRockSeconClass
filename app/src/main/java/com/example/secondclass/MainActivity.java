package com.example.secondclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2_layout);
        ViewPager2 viewPager2 = findViewById(R.id.myViewPager);
        viewPager2.setAdapter(new ViewPagerAdapter());
        init();
    }

    private void init() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("第一页"));
        fragments.add(BlankFragment.newInstance("第二页"));
        fragments.add(BlankFragment.newInstance("第三页"));

        viewPager2 = findViewById(R.id.myViewPager);
        viewPager2.setAdapter(new MyAdapterLevel3(getSupportFragmentManager(),
                getLifecycle(),fragments));

        new TabLayoutMediator(findViewById(R.id.mTabLayout),viewPager2,new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("1");
                        break;
                    case 1:
                        tab.setText("2");
                        break;
                    case 2:
                        tab.setText("3");
                        break;
                }
            }
        }).attach();
    }
    }

