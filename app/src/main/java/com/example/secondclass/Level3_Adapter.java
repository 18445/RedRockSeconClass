package com.example.secondclass;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

class MyAdapterLevel3 extends FragmentStateAdapter {
    List<Fragment> fragments;

    public MyAdapterLevel3(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<Fragment> pfragments) {
        super(fragmentManager,lifecycle);
        fragments=pfragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}