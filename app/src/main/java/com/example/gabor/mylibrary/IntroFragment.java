package com.example.gabor.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class IntroFragment extends Fragment implements AsyncResponse{

    public static Context contextOfApplication;
    Adapter adapter;
    ListView listView;

    public IntroFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contextOfApplication = getActivity().getApplicationContext();
        new FetchLibrary(this,"http://friendlibrary.azurewebsites.net/api/book/list", this.getClass()).execute();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_intro, container, false);
        View rootView = inflater.inflate(R.layout.fragment_intro, container, false);

        contextOfApplication = getActivity().getApplicationContext();
        listView = (ListView) rootView.findViewById(R.id.lvLocations);

        return rootView;
    }


    @Override
    public void processFinish(ArrayList<Object> strings) {
        if(strings == null){
            Toast.makeText(getActivity().getBaseContext(), "Something went wrong (array is null), please try again!", Toast.LENGTH_SHORT).show();
        }else if(isAdded()){

            System.out.println(strings);
            adapter = new Adapter(getActivity().getBaseContext() , R.layout.listview_item1, strings);
            listView.setAdapter(adapter);
        }
    }


}
