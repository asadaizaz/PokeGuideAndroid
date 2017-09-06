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
public class FragmentTwo extends Fragment{
    private Integer[] mThumbIds =
            {
                 R.drawable.bulb1, R.drawable.bulb2, R.drawable.bulb3,
                    R.drawable.charm1, R.drawable.charm2, R.drawable.charm3,
                    R.drawable.squ1, R.drawable.squ2, R.drawable.squ3,
                    R.drawable.ek1, R.drawable.ek2, R.drawable.sand1, R.drawable.sand2,
                    R.drawable.nidf1, R.drawable.nidf2, R.drawable.nidf3, R.drawable.nidm1,
                    R.drawable.nidm2, R.drawable.nidm3, R.drawable.vul1, R.drawable.vul2, R.drawable.od1,
                    R.drawable.od2, R.drawable.od3, R.drawable.par1, R.drawable.par2, R.drawable.ven1,
                    R.drawable.ven2, R.drawable.dig1, R.drawable.dig2, R.drawable.mew1, R.drawable.mew2,
                    R.drawable.psy1, R.drawable.psy2, R.drawable.man1, R.drawable.man2, R.drawable.gr1,
                    R.drawable.gr2, R.drawable.pol1, R.drawable.pol2, R.drawable.pol3, R.drawable.ab1,
                    R.drawable.ab2, R.drawable.ab3, R.drawable.ma1, R.drawable.ma2, R.drawable.ma3,
                    R.drawable.bel1, R.drawable.bel2, R.drawable.bel3, R.drawable.te1, R.drawable.te2,
                    R.drawable.pon1, R.drawable.pon2, R.drawable.slo1, R.drawable.slo2, R.drawable.mag1,
                    R.drawable.mag2, R.drawable.far1, R.drawable.du1, R.drawable.du2, R.drawable.se1,
                    R.drawable.se2, R.drawable.gr1, R.drawable.gr2, R.drawable.shel1, R.drawable.shel2,
                    R.drawable.gas1, R.drawable.gas2, R.drawable.gas3, R.drawable.dr1, R.drawable.dr2,
                    R.drawable.kr1, R.drawable.kr2, R.drawable.vol1, R.drawable.vol2, R.drawable.exe1,
                    R.drawable.exe2, R.drawable.cub1, R.drawable.cub2, R.drawable.lick1, R.drawable.kof,
                    R.drawable.kof2, R.drawable.ry1, R.drawable.ry2, R.drawable.tan1, R.drawable.kan,
                    R.drawable.hor1, R.drawable.hor2, R.drawable.gol1, R.drawable.gol2, R.drawable.star1,
                    R.drawable.star2, R.drawable.tar1, R.drawable.por
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
        mGridView = (GridView) v.findViewById(R.id.gridview);
        mGridView.setAdapter(new ImageAdapter(getContext(), mThumbIds));


        return v;
    }
}

