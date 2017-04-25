package mx.lfa.com.rawrstudio.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import mx.lfa.com.rawrstudio.R;

/**
 * Created by Tonatiuh on 20/04/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {
    int[] images;
    LayoutInflater inflater;
    Context context;

    public ViewPagerAdapter(Context patrocinadores, int[] img) {
        this.context = patrocinadores;
        this.images = img;
    }

    public ViewPagerAdapter(FragmentManager supportFragmentManager) {

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView trailimg;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_sponsor, container, false);
        trailimg=(ImageView)itemView.findViewById(R.id.trailing);
        //trailimg.setImageResource(images[position]);

        Glide.with(context).load(images[position]).into(trailimg);
        ((ViewPager)container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
