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
public class FragmentThreeEgg extends Fragment {
    private Integer[] mThumbIds =
            {

                    R.drawable.on1, R.drawable.hit1, R.drawable.hit2, R.drawable.chan1,
                   R.drawable.sc1, R.drawable.jynx, R.drawable.ele1,
                    R.drawable.magmar,  R.drawable.lap1, R.drawable.evee1,
                  R.drawable.om1,
                    R.drawable.kab1, R.drawable.aero1, R.drawable.snor1,
                    R.drawable.drat1, R.drawable.smoochum, R.drawable.elekid, R.drawable.magby
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
