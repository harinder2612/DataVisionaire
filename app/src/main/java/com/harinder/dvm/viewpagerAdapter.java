package com.harinder.dvm;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.harinder.dvm.Fragments.AnalayticsFragment;
import com.harinder.dvm.Fragments.LiveQueries;
import com.harinder.dvm.Fragments.QueriesFragment;

public class viewpagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Queries", "Analytics","Live"};


    public viewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new QueriesFragment();
        }
        else if(position==1)
        {
            return new AnalayticsFragment();
        }
        {
            return new LiveQueries();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
