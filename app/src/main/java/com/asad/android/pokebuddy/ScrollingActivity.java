package com.asad.android.pokebuddy;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.asad.android.pokebuddy.Helper.Pokemon;
import com.asad.android.pokebuddy.Helper.PokemonHelper;
import com.asad.android.pokebuddy.egg.EggActivity;
import com.asad.android.pokebuddy.evolution.EvolutionActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private ArrayAdapter<String> mAdapter;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;


    InterstitialAd mInterstitialAd;

    private static final String TAG = ScrollingActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5985183480894401/4014259776");



        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName("Egg Distances");
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
                            startActivity(EggActivity.class);

                        }
return true;
                    }
                }).build();


        PokemonHelper pokemonHelper = PokemonHelper.getInstance(loadJSONFromAsset());

        ArrayList<Pokemon> test = pokemonHelper.getPokemons();

        for(int i = 0 ; i< test.size(); i++) {
            Log.d(TAG, test.get(i).getName() + "  " + test.get(i).getId() + "  " );


        }



    }

    private void requestNewInterstitial()
    {
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public String loadJSONFromAsset()
    {
        String json = null;
        try {
            InputStream is = getAssets().open("pokedex.json");
            int size  = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        }catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        return json;
    }
private void startActivity(Class className)
{
    Intent intent = new Intent(this, className);
     startActivity(intent);

}


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "1 KM");
        adapter.addFragment(new FragmentTwo(), "3 KM");
        adapter.addFragment(new FragmentThree(), "5 KM");
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

