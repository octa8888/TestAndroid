package com.example.testapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Vector;

public class ImageAdapter extends PagerAdapter {

    public Vector<Integer> images= new Vector<>();
    public Context context;

    public ImageAdapter(Context context){
        this.context=context;
        images.add(R.drawable.anjing);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_background);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup v, int idx) {
        ImageView iv= new ImageView(context);
        iv.setImageResource(images.get(idx));
        v.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }
}
