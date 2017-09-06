package com.asad.android.pokebuddy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Asad on 9/11/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    private Integer[] mThumbIds;

    public ImageAdapter(Context c, Integer[] icons) {
        mContext = c;
        mThumbIds = icons;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(getPx(100), getPx(100)));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


    private int getPx(int dimensionDp)
    {
        float density = mContext.getResources().getDisplayMetrics().density;

        return (int)(dimensionDp * density + 0.5f);
    }
}
