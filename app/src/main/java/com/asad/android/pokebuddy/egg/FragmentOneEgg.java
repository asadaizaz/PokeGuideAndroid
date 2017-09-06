package com.asad.android.pokebuddy.egg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.asad.android.pokebuddy.ImageAdapter;
import com.asad.android.pokebuddy.R;

/**
 * Created by Asad on 9/16/2016.
 */
public class FragmentOneEgg extends Fragment {
    private Integer[] mThumbIds =
            {R.drawable.bulb1, R.drawable.charm1, R.drawable.squ1,
                    R.drawable.iconpickachu,
                    R.drawable.ten,  R.drawable.thirteen,
                  R.drawable.sixteen,
                R.drawable.nineteen,
                  R.drawable.twentyone,
                    R.drawable.clef1,  R.drawable.jigg1,
                    R.drawable.zubat1,  R.drawable.geo1,
                    R.drawable.magi1, R.drawable.igglybuff, R.drawable.cleffa1
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
