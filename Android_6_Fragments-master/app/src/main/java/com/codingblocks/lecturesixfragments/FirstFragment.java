package com.codingblocks.lecturesixfragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    TextView fragName;

    int studentId;

    private OnCreateViewCalledListener ocvcl;

    public void setOnCreateViewCalledListener(OnCreateViewCalledListener ocvcListener){
       if(ocvcl!=null){ ocvcl = ocvcListener;}
    }


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(ocvcl!=null) {
            ocvcl.onCreateViewCalled();
        }
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        fragName = (TextView) rootView.findViewById(R.id.tv_fragment_name);
        fragName.setTextColor(Color.RED);

        if(getActivity() instanceof DynamicFragmentActivity) {


            ((DynamicFragmentActivity) getActivity()).showToast();
        }

            return rootView;
    }

    public interface OnCreateViewCalledListener{
        void onCreateViewCalled();
    }
}
