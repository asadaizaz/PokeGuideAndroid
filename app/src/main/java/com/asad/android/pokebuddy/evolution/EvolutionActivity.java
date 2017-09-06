package com.asad.android.pokebuddy.evolution;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.asad.android.pokebuddy.Helper.Pokemon;
import com.asad.android.pokebuddy.Helper.PokemonHelper;
import com.asad.android.pokebuddy.R;
import com.asad.android.pokebuddy.ScrollingActivity;
import com.asad.android.pokebuddy.egg.EggActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

/**
 * Created by Asad on 9/18/2016.
 */
public class EvolutionActivity extends AppCompatActivity{

    private EditText mCpEditText;
    private Spinner mSpinnerChoices;
    private TextView mPokeOG;
    private TextView mPokeResult;
private TextView mPokeThirdText;

    private ImageView mPokeResultIcon;
    private ImageView mPokeEnterIcon;


    private ImageView mPokeThirdIcon;
    private Toolbar mToolbar;


    private TextView mCPTextOne;
    private TextView mCPTextTwo;
    private TextView mCPTextThree;

    Pokemon mPokemon;
    int mCp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expermimental);

        mCpEditText = (EditText) findViewById(R.id.cp_text);
        mSpinnerChoices = (Spinner)findViewById(R.id.poke_name);
        mPokeOG = (TextView)findViewById(R.id.poke_enter_name);
        mPokeResult = (TextView) findViewById(R.id.poke_result_name);

        mPokeThirdText = (TextView) findViewById(R.id.pokemon_third_text);
        mPokeThirdIcon = (ImageView) findViewById(R.id.pokemon_third_icon);
        mPokeResultIcon = (ImageView)findViewById(R.id.poke_result_icon);
        mPokeEnterIcon = (ImageView)findViewById(R.id.poke_enter_icon);

        mCPTextOne =(TextView)findViewById(R.id.cp_first);
        mCPTextTwo =(TextView)findViewById(R.id.cp_second);
        mCPTextThree =(TextView)findViewById(R.id.cp_third);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_evo);
        setSupportActionBar(mToolbar);


//        AdView mAdView = (AdView)findViewById(R.id.adView_evo);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);


     setupSpinner();


        editTextListen();

setupDrawer();

    }

    private void editTextListen()
    {
        mCpEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;

                if(actionId== EditorInfo.IME_ACTION_NEXT)
                {
                    handled = true;

                    if(!containsOnlyNumbers(mCpEditText.getText().toString())) {
                        Toast.makeText(EvolutionActivity.this, "Please enter valid value", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        mCp = Integer.parseInt(mCpEditText.getText().toString());
                        doCalculations(mPokemon, mCp);

                        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }
                return handled;
            }
        });
    }

    private void setupSpinner()
    {
        ArrayList<Pokemon> names = PokemonHelper.getOnlyEvoPokemons();


        ArrayAdapter<Pokemon> adapter= new ArrayAdapter<Pokemon>(this, android.R.layout.simple_spinner_item, names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerChoices.setAdapter(adapter);

        mSpinnerChoices.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mPokemon = (Pokemon) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private   boolean containsOnlyNumbers(String str) {
        if(str.isEmpty() || str ==null)
        {
            return false;
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i)))
                    return false;
            }
        }
        return true;
    }
    private void startActivity(Class className)
    {
        Intent intent = new Intent(this, className);
        startActivity(intent);

    }


    private int getImage(String name)
    {
        return  getResources().getIdentifier("drawable/" + name, null,getPackageName());
    }
    private void doCalculations(Pokemon pokemon, int cp)
    {
        int imageRes = getResources().getIdentifier("drawable/" + pokemon.getIcon(), null,getPackageName());

        if(pokemon.getId() == 133)
        {
            mPokeOG.setText("Vaporean");
            mCPTextOne.setText(""+ Math.round(cp * 2.77)+ " CP");

            mPokeResult.setText("Jolteon");
            mCPTextTwo.setText(Math.round(cp * 2.14) + " CP");
            mPokeThirdText.setText("Flareon");
            mCPTextThree.setText( ""+Math.round(cp * 2.56) + " CP");

            mPokeEnterIcon.setImageResource(getImage("evee2"));
            mPokeResultIcon.setImageResource(getImage("evee3"));
            mPokeThirdIcon.setImageResource(getImage("evee4"));

        }
//        if(pokemon.getId() == 174)
//        {
//            mPokeOG.setText("Igglybuff");
//            mCPTextOne.setText(""+ cp+ " CP");
//
//            mPokeResult.setText("Jigglypuff");
//            double cp2 = cp * 1.17;
//            mCPTextTwo.setText(Math.round(cp2) + " CP");
//
//            mPokeThirdText.setText("Wigglytuff");
//            mCPTextThree.setText( ""+Math.round(cp2 * 1.85) + " CP");
//
//            mPokeEnterIcon.setImageResource(getImage("igglybuff"));
//            mPokeResultIcon.setImageResource(getImage("jigg1"));
//            mPokeThirdIcon.setImageResource(getImage("jigg2"));
//
//        }
//
//        if(pokemon.getId() == 173)
//        {
//            mPokeOG.setText("Cleffa");
//            mCPTextOne.setText(""+ cp+ " CP");
//
//            mPokeResult.setText("Clefairy");
//            double cp2 = cp * 1.81;
//            mCPTextTwo.setText(Math.round(cp2) + " CP");
//
//            mPokeThirdText.setText("Wigglytuff");
//            mCPTextThree.setText( ""+Math.round(cp2 * 1.85) + " CP");
//
//            mPokeEnterIcon.setImageResource(getImage("igglybuff"));
//            mPokeResultIcon.setImageResource(getImage("jigg1"));
//            mPokeThirdIcon.setImageResource(getImage("jigg2"));
//
//        }

        else{

        mPokeOG.setText(pokemon.getName());
        mCPTextOne.setText(cp + " CP");
        mPokeEnterIcon.setImageResource(imageRes);



        //Hack for evee




                Pokemon nextPokemon = PokemonHelper.getPokemon(pokemon.getId() + 1);

            if(pokemon.getId() == 174)
            {
                nextPokemon = PokemonHelper.getPokemon(39);

            }
            if(pokemon.getId() == 173)
            {
                nextPokemon = PokemonHelper.getPokemon(35);
            }

            if(pokemon.getId() == 172)
            {
                nextPokemon = PokemonHelper.getPokemon(25);
            }

            if(pokemon.getId() == 175)
            {
                nextPokemon = PokemonHelper.getPokemon(176);
            }
            if(pokemon.getId() == 238)
            {
                nextPokemon = PokemonHelper.getPokemon(124);
            }

            if(pokemon.getId() == 239)
            {
                nextPokemon = PokemonHelper.getPokemon(125);
            }

            if(pokemon.getId() == 240)
            {
                nextPokemon = PokemonHelper.getPokemon(126);
            }



            int finalCp = (int) Math.round(cp * pokemon.getMultipliers());

            mPokeResult.setText(nextPokemon.getName());
            mCPTextTwo.setText(""+ finalCp+ " CP");
            int imageRes2 = getResources().getIdentifier("drawable/" + nextPokemon.getIcon(), null, getPackageName());

            mPokeResultIcon.setImageResource(imageRes2);

            if(nextPokemon.getMultipliers()!= 0.0)
            {
                Pokemon third = PokemonHelper.getPokemon(nextPokemon.getId()+1);
                int thirdCp = (int) Math.round(finalCp * nextPokemon.getMultipliers());
                mPokeThirdText.setText(third.getName());
                mCPTextThree.setText(""+ thirdCp+ " CP");

                int imageRes3 = getResources().getIdentifier("drawable/" + third.getIcon(), null, getPackageName());

                mPokeThirdIcon.setImageResource(imageRes3);

            }
            else {
                mPokeThirdText.setText("");
                mPokeThirdIcon.setImageResource(android.R.color.transparent);
                mCPTextThree.setText("");
            }

        }

    }


    private void setupDrawer()
    {
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName("Egg Distances");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withName("Buddy Distances");
        new DrawerBuilder().withActivity(this).build();
        Drawer result = new DrawerBuilder().withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(item1, item2)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if (position == 1) {
                            startActivity(EggActivity.class);


                            return true;
                        } else {
                            startActivity(ScrollingActivity.class);

                        }
                        return true;
                    }
                }).build();

    }


}