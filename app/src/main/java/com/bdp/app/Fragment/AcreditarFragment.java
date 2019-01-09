package com.bdp.app.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.bdp.app.Activity.MainActivity;
import com.bdp.app.R;


public class AcreditarFragment extends Fragment {


    private RadioGroup radioInversion;


    public AcreditarFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acreditar, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        radioInversion = (RadioGroup) getView().findViewById(R.id.radioInversion);



        radioInversion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                MainActivity.inversion(getActivity(),checkedId);


            }
        });



    }



    /* */



}
