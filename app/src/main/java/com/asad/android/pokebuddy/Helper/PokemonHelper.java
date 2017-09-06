package com.asad.android.pokebuddy.Helper;

import android.util.Log;

import com.asad.android.pokebuddy.ScrollingActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Asad on 9/18/2016.
 */
public class PokemonHelper {



    private static final ArrayList<Pokemon> mPokemons = new ArrayList<Pokemon>();

    public static ArrayList<Pokemon> getOnlyEvoPokemons() {
        return mOnlyEvoPokemons;
    }

    private static final ArrayList<Pokemon> mOnlyEvoPokemons = new ArrayList<>();

    public static ArrayList<String> getPokemonNames() {
        return mPokemonNames;
    }

    private static final ArrayList<String> mPokemonNames = new ArrayList<String>();
    private static int []  noEvoID = {
            3,6,9,12,15,18,20,22,24,26,28,31,34,36,38,40,45,47,49,51,53,55,57,59,62,65,68,71,73,
            76,78,80,83,82,85,87,89,91,94,95,97,99,101,103,105,106,107,108, 110,112,113,114,115,117,119,121,122,123,124,125,126,127,
            128,130,131,132,134,135,136,137,139,141,142,143,144,145,146,149,150,151, 176
    };

    private static PokemonHelper sPokemonHelper = null;
    public static PokemonHelper getInstance(String response)
    {
        if(sPokemonHelper==null)
        {
            sPokemonHelper = new PokemonHelper(response);

        }
        return  sPokemonHelper;

    }
    private PokemonHelper(String response)
    {
        initialize(response);
    }
    public static ArrayList<Pokemon> getPokemons() {
        return mPokemons;
    }

    private void initialize(String response)
    {
        populateData(response);
        getListOfAllPokeNames();
    }

    public static ArrayList<Pokemon> getPokemonsNoEvo()
    {
        ArrayList<Pokemon> temp = new ArrayList<Pokemon>();
        for(int i = 0; i < mPokemons.size(); i++)
        {
            if(mPokemons.get(i).getId() == noEvoID[i])
            {
                temp.add(mPokemons.get(i));

            }
        }

        return temp;
    }

public static ArrayList<String> getListofNamesFromArray(ArrayList<Pokemon> list)
{
    ArrayList<String> names = new ArrayList<String>();
    for(int i =0; i < list.size(); i++)
    {
        names.add(list.get(i).getName());
    }

    return names;

}
    private  void getListOfAllPokeNames()
    {
        for(int i =0; i < mPokemons.size(); i++)
        {
            mPokemonNames.add(mPokemons.get(i).getName());
        }

    }



    public static int getIdFromName(String name)
    {
        for(int i = 0; i < mPokemons.size(); i++)
        {
            if(mPokemons.get(i).getName() == name)
            {
                return mPokemons.get(i).getId();
            }
        }
        return 1;
    }

    public static  String getNameFromId(int id)
    {
        for(int i = 0; i < mPokemons.size(); i++)

        {
            if(mPokemons.get(i).getId() == id)
            {
                return mPokemons.get(i).getName();
            }
        }
        return "error";
    }

    public static Pokemon getPokemon(int id)
    {
        for(int i = 0; i < mPokemons.size(); i++)
        {
            if(mPokemons.get(i).getId()==id)
            {
                return mPokemons.get(i);
            }
        }
        return null;

    }
    private void populateData(String response) {
        try {

            JSONObject obj  = new JSONObject(response);
            JSONArray array = obj.getJSONArray("pokemon");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Pokemon pokemon = new Pokemon();
                pokemon.setName(jsonObject.getString("name"));
                pokemon.setId(jsonObject.getInt("id"));
                pokemon.setIcon(jsonObject.getString("icon"));

                Object values = jsonObject.get("multipliers");



                if(values instanceof  JSONArray)
                {
                    JSONArray itemsArray = (JSONArray) values;
                    double num1 = (double)itemsArray.get(1);
                    double num2 = (double)itemsArray.get(0);

                    double avg = (num1 + num2) / 2;
                    pokemon.setMultipliers(avg);

                }
                else if(values instanceof  Double)
                {
                    pokemon.setMultipliers((double)values);
                }

                mPokemons.add(pokemon);
                mOnlyEvoPokemons.add(pokemon);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < mOnlyEvoPokemons.size();i ++)
       {
            for(int j = 0; j < noEvoID.length; j++)
            {
                if(mOnlyEvoPokemons.get(i).getId() == noEvoID[j])
                {
                   mOnlyEvoPokemons.remove(mOnlyEvoPokemons.get(i));
                }
            }
        }


    }

}
