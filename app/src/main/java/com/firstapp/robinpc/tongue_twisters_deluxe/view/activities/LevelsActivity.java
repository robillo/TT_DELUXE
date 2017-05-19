package com.firstapp.robinpc.tongue_twisters_deluxe.view.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.adapters.RVAFeature;
import com.firstapp.robinpc.tongue_twisters_deluxe.controller.ZoomOutPageTransformer;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.fragments.LevelsFragment;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.holders.Feature;
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

import java.util.ArrayList;
import java.util.List;

public class LevelsActivity extends AppCompatActivity {


    boolean doubleBackToExitPressedOnce = false;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int intent_page;
    private int[] layouts;
    private RecyclerView recyclerView;
    private List<Feature> list;
    private String[] levels, levelHeaders, photoUrls;

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

        Intent i = getIntent();
        intent_page = i.getIntExtra("tab", 1);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        assignStringValues();

        // Instantiate a ViewPager and a PagerAdapter.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
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

        list = new ArrayList<>();
        list.add(new Feature("Your Twisters", "Use Your Imagination To Create Your Own Twisters.", "https://3.bp.blogspot.com/-FTKj7QUV61w/WJBgEaJclgI/AAAAAAAAAFw/dX-wb54JX-AYiDGPPB1Z3lvS7ZCoUNKBACLcB/s1600/ph6.png", 1));
        list.add(new Feature("Share App With Friends", "Enable Your Friends Gain Access To The Vast Collection Of Tongue Twisters.", "https://3.bp.blogspot.com/-FTKj7QUV61w/WJBgEaJclgI/AAAAAAAAAFw/dX-wb54JX-AYiDGPPB1Z3lvS7ZCoUNKBACLcB/s1600/ph6.png", 2));
        list.add(new Feature("Review App?", "Like the App? Or Do You Want an additional feature to be added to be app? Here's The Place You Seek.", "https://3.bp.blogspot.com/-FTKj7QUV61w/WJBgEaJclgI/AAAAAAAAAFw/dX-wb54JX-AYiDGPPB1Z3lvS7ZCoUNKBACLcB/s1600/ph6.png", 3));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new RVAFeature(getApplicationContext(), list));
    }

    private void assignStringValues(){
        levels = getResources().getStringArray(R.array.levels);
        levelHeaders = getResources().getStringArray(R.array.levelHeaders);
        photoUrls = getResources().getStringArray(R.array.photoUrls);
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
        /*
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }*/
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_levels, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_settings:{
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                break;
            }
            case R.id.action_about:{
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
            }
            case R.id.action_rate:{
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.firstapp.robinpc.tongue_twisters_deluxe"));
                startActivity(i);
                break;
            }
            case R.id.action_share:{
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, "Hey, Check out this exciting App at: https://play.google.com/store/apps/details?id=com.firstapp.robinpc.tongue_twisters_deluxe");
                i.setType("text/plain");
                startActivity(i);
                break;
            }
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

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:{
                    return assignFragment(0);
                }
                case 1:{
                    return assignFragment(1);
                }
                case 2:{
                    return assignFragment(2);
                }
                case 3:{
                    return assignFragment(3);
                }
                case 4:{
                    return assignFragment(4);
                }
                case 5:{
                    return assignFragment(5);
                }
                case 6:{
                    return assignFragment(6);
                }
                case 7:{
                    return assignFragment(7);
                }
                case 8:{
                    return assignFragment(8);
                }
                case 9:{
                    return assignFragment(9);
                }
                default:{
                    return assignFragment(0);
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

    private Fragment assignFragment(int position){
        Fragment fragment = new LevelsFragment();
        Bundle args = new Bundle();
        args.putString("level", levels[position]);
        args.putString("levelHeader", levelHeaders[position]);
        args.putString("photoUrl", photoUrls[position]);
        fragment.setArguments(args);
        return fragment;
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
