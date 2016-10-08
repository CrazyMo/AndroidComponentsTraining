package com.crazymo.androidtraining;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    static final private int[] guidesImg={R.mipmap.img_guide_1,R.mipmap.img_guide_2,R.mipmap.img_guide_3};
    private List<View> imageViewList=new ArrayList<View>();//定义同于显示引导页的控件ImageVIew
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        viewPager= (ViewPager) findViewById(R.id.id_viewpager_guide);
        initViewPager();

    }
    private void initViewPager(){
        viewPager.setAdapter(new GuidePagerAdapter());
    }

    private class GuidePagerAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=new ImageView(MainActivity.this);
            //imageView.setImageResource(guidesImg[position]);
            imageView.setBackgroundResource(guidesImg[position]);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imageView);
            imageViewList.add(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViewList.get(position));
        }

        @Override
        public int getCount() {
            return guidesImg.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
