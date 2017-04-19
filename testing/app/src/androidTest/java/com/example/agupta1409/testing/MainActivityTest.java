package com.example.agupta1409.testing;


import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dalvik.annotation.TestTargetClass;

/**
 * Created by a.gupta1409 on 30-07-2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
MainActivity mainAct;
    @Rule
    public final ActivityTestRule<MainActivity> act =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Rule
    public void setUpAcivity() throws Exception {
        mainAct = act.getActivity();
//        act.launchActivity()
    }

    @After
    public void finishActivity() throws Exception{
        mainAct.finish();
    }

    @Test@UiThreadTest
    public void simpleFareTest() throws Exception{
        ((EditText)mainAct.findViewById(R.id.et_time)).setText("3");
        ((EditText)mainAct.findViewById(R.id.et_kms)).setText("16");
        ((Button)mainAct.findViewById(R.id.btn_fare)).callOnClick();

        assertEquals("Fare: 35.0",((TextView)mainAct.findViewById(R.id.tv_fare)).getText());
    }
}
