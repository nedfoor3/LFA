package mx.lfa.com.rawrstudio.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.views.Patrocinadores;

/**
 * Created by Tonatiuh on 20/04/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {
    int[] images;
    LayoutInflater inflater;
    Context context;

    public ViewPagerAdapter(Patrocinadores patrocinadores, int[] img){
        this.context = patrocinadores;
        this.images = img;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView trailimg;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_sponsor, container, false);
        trailimg=(ImageView)itemView.findViewById(R.id.trailing);
        trailimg.setImageResource(images[position]);
        ((ViewPager)container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((RelativeLayout)object);
    }
}
