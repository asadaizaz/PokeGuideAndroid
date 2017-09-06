package com.asad.android.pokebuddy.egg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.asad.android.pokebuddy.R;
import com.asad.android.pokebuddy.ScrollingActivity;
import com.asad.android.pokebuddy.evolution.EvolutionActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asad on 9/16/2016.
 */
public class EggActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    InterstitialAd mInterstitialAd;
     boolean ended = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5985183480894401/4014259776");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {


            }

            @Override
            public void onAdLoaded() {

                if(mInterstitialAd.isLoaded())
                {

                        mInterstitialAd.show();

                    }

            }
        });
        requestNewInterstitial();



            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mToolbar);
            mToolbar = (Toolbar) findViewById(R.id.toolbar);


            mViewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(mViewPager);

            mTabLayout = (TabLayout) findViewById(R.id.tabs);
            mTabLayout.setupWithViewPager(mViewPager);
            PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName("Buddy Distances");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withName("Evolution Calculator");

        new DrawerBuilder().withActivity(this).build();
            Drawer result = new DrawerBuilder().withActivity(this)
                    .withToolbar(mToolbar)
                    .addDrawerItems(item1, item2)
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            if (position == 1) {
                                startActivity(EvolutionActivity.class);


                                return true;
                            } else {
                                startActivity(ScrollingActivity.class);


                            }
                            return true;
                        }
                    }).build();


        }



    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()

                .build();

        mInterstitialAd.loadAd(adRequest);
    }
    private void startActivity(Class className)
    {
        Intent intent = new Intent(this, className);
        startActivity(intent);

    }




    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOneEgg(), "2 KM");
        adapter.addFragment(new FragmentTwoEgg(), "5 KM");
        adapter.addFragment(new FragmentThreeEgg(), "10 KM");
        viewPager.setAdapter(adapter);

    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

