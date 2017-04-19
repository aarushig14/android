package com.codingblocks.lecturesixfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    public int stID;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(int stuID){
        Bundle args = new Bundle();
        args.putInt("studentId",stuID);

        BlankFragment bf = new BlankFragment();
        bf.setArguments(args);
        return bf;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}
