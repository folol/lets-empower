package com.example.devansh.womensecutiry;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Devansh on 11/21/2015.
 */
public class InfoFragment extends Fragment {




    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.info_layout, container, false);
        EditText et1=(EditText) rootView.findViewById(R.id.editText);
        EditText et2=(EditText) rootView.findViewById(R.id.editText1);
        EditText et3=(EditText) rootView.findViewById(R.id.editText2);
        EditText et4=(EditText) rootView.findViewById(R.id.editText3);
        EditText et5=(EditText) rootView.findViewById(R.id.editText4);
        EditText et6=(EditText) rootView.findViewById(R.id.editText5);
        EditText et7=(EditText) rootView.findViewById(R.id.editText6);
        EditText et8=(EditText) rootView.findViewById(R.id.editText7);

        SharedPreferences prefs=getActivity().getSharedPreferences("info_details", Context.MODE_PRIVATE);
        String name=prefs.getString("name", "Name");
        String email=prefs.getString("email","Email");
        String address=prefs.getString("address","Address");
        String message=prefs.getString("MESSAGE","Message");
        String police_no=prefs.getString("POLICE_NUMBER","Police No.");
        String emergency1=prefs.getString("EMER_CONTACT_ONE","Emergency Contact 1");
        String emergency2=prefs.getString("EMER_CONTACT_TWO", "Emergency Contact 2");
        String emergency3=prefs.getString("EMER_CONTACT_THREE", "Emergency Contact 3");

        et1.setText(name);
        et2.setText(email);
        et3.setText(address);
        et4.setText(message);
        et5.setText(police_no);
        et6.setText(emergency1);
        et7.setText(emergency2);
        et8.setText(emergency3);

        return  rootView;

    }
}
