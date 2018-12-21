package com.frocerie.demoalqalam;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by avocet on 11/05/17.
 */

public class ViewPageAdapter extends PagerAdapter {


    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.drawable.innerdesko,R.drawable.innerdeskth,R.drawable.innerdeskt,R.drawable.innerdeskf};


    public ViewPageAdapter(Context context) {


        this.context = context;
    }


    @Override
    public int getCount() {


        return images.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }


    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);


    }

}