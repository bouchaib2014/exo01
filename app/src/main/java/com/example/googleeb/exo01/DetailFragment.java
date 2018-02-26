package com.example.googleeb.exo01;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView nameTextView = (TextView) v.findViewById(R.id.name);
        TextView ageTextView = (TextView) v.findViewById(R.id.age);

        String name = "name";
        String age = "21 years old";

        // TODO get data from build and set text views
        if (getArguments() != null){
            Bundle bundle = getArguments();
            name = bundle.getString(ListFragment.NAME, "name");
            age = bundle.getString(ListFragment.AGE, "age")+"years old";
        }



        nameTextView.setText(name);
        ageTextView.setText(age);

        return v;
    }

}
