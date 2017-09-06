package com.asad.android.pokebuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * Created by Asad on 9/11/2016.
 */
public class FragmentOne extends Fragment{
    private Integer[] mThumbIds =
            {
                    R.drawable.iconpickachu, R.drawable.iconraichu,
                    R.drawable.ten, R.drawable.eleven, R.drawable.twelve, R.drawable.thirteen,
                    R.drawable.fourteen, R.drawable.fifteen, R.drawable.sixteen,
                    R.drawable.seventeen, R.drawable.eighteen, R.drawable.nineteen,
                    R.drawable.twenty, R.drawable.twentyone, R.drawable.twentytwo,
                    R.drawable.clef1, R.drawable.clef2, R.drawable.jigg1, R.drawable.jigg2,
                    R.drawable.zubat1, R.drawable.zubat2, R.drawable.geo1, R.drawable.geo2,
                    R.drawable.geo3, R.drawable.magi1, R.drawable.magi2, R.drawable.igglybuff, R.drawable.cleffa1,  R.drawable.pichu
            };
    GridView mGridView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_one, container, false);
       mGridView  = (GridView) v.findViewById(R.id.gridview);
        mGridView.setAdapter(new ImageAdapter(getContext(), mThumbIds));



        return v;
    }
}
