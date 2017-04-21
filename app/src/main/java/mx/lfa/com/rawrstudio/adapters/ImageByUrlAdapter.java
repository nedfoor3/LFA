package mx.lfa.com.rawrstudio.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.views.NewsActivity;

/**
 * Created by Ricardo Rodriguez on 4/20/2017.
 */

public class ImageByUrlAdapter extends PagerAdapter {

    private LayoutInflater inflater;
    private String[] urls;
    private Context activity;

    public ImageByUrlAdapter(NewsActivity activity, String[] urlsImage) {
        this.urls = urlsImage;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return urls.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView trailimg;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.pager_image_gallery, container, false);
        trailimg = (ImageView) itemView.findViewById(R.id.image_gallery);
        //trailimg.setImageResource(images[position]);

        Glide.with(activity).load(urls[position]).into(trailimg);
        ((ViewPager) container).addView(itemView);
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