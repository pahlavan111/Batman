package com.bp.batman.details;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bp.batman.R;
import com.bp.batman.base.BaseFragment;


public class DetailsFragment extends BaseFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle= getArguments();
        assert bundle != null;
        String imdbId= bundle.getString("imdbId");

        Toast.makeText(getContext(), imdbId, Toast.LENGTH_SHORT).show();


        }

    @Override
    public int getLayout() {
        return R.layout.fragment_details;
    }

    @Override
    public void setUpViews() {

    }


}

