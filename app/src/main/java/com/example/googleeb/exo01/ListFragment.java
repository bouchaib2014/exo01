package com.example.googleeb.exo01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    public final static String NAME = "name";
    public final static String AGE = "age";

    private ArrayList<HashMap<String, String>> list;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = (ListView) v.findViewById(R.id.list_view);

        // TODO create table "String[][]" for name and age about 12 items
        String[][] listItems = {
                {"name1", "20"},
                {"name2", "22"},
                {"name3", "23"},
                {"name4", "24"},
                {"name5", "25"},
                {"name6", "26"},
                {"name7", "27"},
                {"name8", "28"},
                {"name9", "29"},
                {"name10", "30"},
                {"name11", "31"},
                {"name12", "32"},
        };

        // TODO create ArrayList with context HashMap<String, String> and convert table to list with loop
        list = new ArrayList<>();
        for (int i=0; i<listItems.length; i++){
            HashMap hashMap = new HashMap<String, String>();
            hashMap.put("name", listItems[i][0]);
            hashMap.put("age", listItems[i][1]);
            list.add(hashMap);
        }

        // TODO create new simple adapter
        SimpleAdapter adapter = new SimpleAdapter(
                getContext(),
                list,
                android.R.layout.simple_list_item_2,
                new String[] {"name", "age"},
                new int[] {android.R.id.text1, android.R.id.text2});

        // TODO set adapter for list view
        listView.setAdapter(adapter);

        // TODO set listener to items list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // TODO get item from list with position
                    HashMap hashMap = list.get(position);

                // TODO get name and age from item "HashMap"
                String name = hashMap.get("name").toString();
                String age = hashMap.get("age").toString();

                // TODO vreate new bundle and putting data
                Bundle bundle = new Bundle();
                bundle.putString(NAME, name);
                bundle.putString(AGE, age);

                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(bundle);

                DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
                float          dpWidth        = displayMetrics.widthPixels / displayMetrics.density;

                if(dpWidth >= 600){
                    getFragmentManager().beginTransaction().addToBackStack("").replace(R.id.detail_container, fragment).commit();
                }else{
                    getFragmentManager().beginTransaction().addToBackStack("").replace(R.id.list_container, fragment).commit();
                }

            }
        });

        return v;
    }

}
