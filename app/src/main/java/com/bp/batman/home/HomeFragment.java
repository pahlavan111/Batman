package com.bp.batman.home;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.bp.batman.R;
import com.bp.batman.base.BaseFragment;
import com.bp.batman.base.BaseView;


public class HomeFragment extends BaseFragment implements BaseView {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void setUpViews() {

    }

    @Override
    public Context getViewContext() {
        return getContext();
    }
}

