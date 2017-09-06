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
public class FragmentTwoEgg extends Fragment {
    private Integer[] mThumbIds =
            {

                    R.drawable.ek1, R.drawable.sand1,
                    R.drawable.nidf1, R.drawable.nidm1,
                R.drawable.vul1, R.drawable.od1,
                    R.drawable.par1, R.drawable.ven1,
                    R.drawable.dig1,R.drawable.mew1,
                    R.drawable.psy1, R.drawable.man1,
                     R.drawable.pol1, R.drawable.ab1,
                R.drawable.ma1,
                    R.drawable.bel1, R.drawable.te1,
                    R.drawable.pon1,  R.drawable.slo1, R.drawable.mag1,
                    R.drawable.du1, R.drawable.se1,
                    R.drawable.gr1, R.drawable.shel1,
                    R.drawable.gas1, R.drawable.dr1,
                    R.drawable.kr1,  R.drawable.vol1, R.drawable.exe1,
                    R.drawable.cub1,  R.drawable.lick1, R.drawable.kof,
                    R.drawable.ry1,R.drawable.tan1,
                    R.drawable.hor1, R.drawable.gol1,R.drawable.star1,
                    R.drawable.por, R.drawable.pichu, R.drawable.togepi
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
