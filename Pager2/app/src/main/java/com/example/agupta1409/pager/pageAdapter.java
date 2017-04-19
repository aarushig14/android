package com.example.agupta1409.pager;

import android.support.v4.app.*;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by a.gupta1409 on 18-07-2016.
 */
public class pageAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> list;

    public pageAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragments) {
        super(supportFragmentManager);
        list = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
