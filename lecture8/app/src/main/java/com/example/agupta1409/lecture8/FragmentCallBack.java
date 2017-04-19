package com.example.agupta1409.lecture8;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCallBack extends Fragment {

    private MyListener listener;

    public void setListener(MyListener ml) {
        listener = ml;
    }

    public FragmentCallBack() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (listener != null) {
            listener.onCallBack();
        }


        return inflater.inflate(R.layout.fragment_fragment_call_back, container, false);
    }


    public interface MyListener {
        void onCallBack();
    }

}
