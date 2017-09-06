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
public class FragmentThree  extends Fragment{
    GridView mGridView;


    private Integer[] mThumbIds =
            {
                    R.drawable.on1, R.drawable.hit1, R.drawable.hit2, R.drawable.chan1,
                    R.drawable.mime, R.drawable.sc1, R.drawable.jynx, R.drawable.ele1,
                    R.drawable.magmar, R.drawable.pin1, R.drawable.lap1, R.drawable.evee1,
                    R.drawable.evee2, R.drawable.evee3, R.drawable.evee4, R.drawable.om1,
                    R.drawable.om2, R.drawable.kab1, R.drawable.kab2, R.drawable.aero1, R.drawable.snor1,
                    R.drawable.drat1, R.drawable.drat2, R.drawable.drat3, R.drawable.art, R.drawable.zap,
                    R.drawable.mol, R.drawable.me1, R.drawable.me2,  R.drawable.togepi, R.drawable.elekid, R.drawable.magby, R.drawable.smoochum
            };
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
