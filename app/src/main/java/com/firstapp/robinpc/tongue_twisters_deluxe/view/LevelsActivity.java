package com.firstapp.robinpc.tongue_twisters_deluxe.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.controller.ZoomOutPageTransformer;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.Slide10Fragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.Slide2Fragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.Slide3Fragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.Slide4Fragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.Slide5Fragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.Slide6Fragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.Slide7Fragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.Slide8Fragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.Slide9Fragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.slides.SlideFragment;

public class LevelsActivity extends AppCompatActivity {

    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 10;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.fragment_slide,
                R.layout.fragment_slide2,
                R.layout.fragment_slide3,
                R.layout.fragment_slide4,
                R.layout.fragment_slide5,
                R.layout.fragment_slide6,
                R.layout.fragment_slide7,
                R.layout.fragment_slide8,
                R.layout.fragment_slide9,
                R.layout.fragment_slide10};

        // adding bottom dots
        addBottomDots(0);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setClipToPadding(false);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_levels, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //nonspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private LayoutInflater layoutInflater;

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:{
                    return new SlideFragment();
                }
                case 1:{
                    return new Slide2Fragment();
                }
                case 2:{
                    return new Slide3Fragment();
                }
                case 3:{
                    return new Slide4Fragment();
                }
                case 4:{
                    return new Slide5Fragment();
                }
                case 5:{
                    return new Slide6Fragment();
                }
                case 6:{
                    return new Slide7Fragment();
                }
                case 7:{
                    return new Slide8Fragment();
                }
                case 8:{
                    return new Slide9Fragment();
                }
                case 9:{
                    return new Slide10Fragment();
                }
                default:{
                    return new SlideFragment();
                }
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public float getPageWidth(int position) {
            return 1.0f;
        }

    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                //btnNext.setText(getString(R.string.start));
                //btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                //btnNext.setText(getString(R.string.next));
                //btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

}