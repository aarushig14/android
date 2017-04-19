package com.example.agupta1409.rachitbday;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by a.gupta1409 on 18-07-2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<myFragment> fragments;
    Context context;

    public ViewPagerAdapter(FragmentManager fm, List<myFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout = (LinearLayout) container.inflate(context,R.layout.fragment_my,null);
        //TODO setLayout()
       EditText et_name_entered = (EditText) linearLayout.findViewById(R.id.et_guess_name);
       Button btnGuess = (Button) linearLayout.findViewById(R.id.btn_guess_made);
       TextView tv_msg = (TextView) linearLayout.findViewById(R.id.tv_birthday_message);
       ImageView image = (ImageView) linearLayout.findViewById(R.id.image_wisher);
       Te tvName = (TextView) linearLayout.findViewById(R.id.tv_name);
        ((ViewPager) container).addView(linearLayout);

        return linearLayout;
    }
}
