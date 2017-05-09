package com.example.gabor.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AsyncResponse{
    public static Context contextOfApplication;
    Adapter adapter;
    ListView listView;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contextOfApplication = getActivity().getApplicationContext();
        new FetchLibrary(this,"http://friendlibrary.azurewebsites.net/api/book/list", this.getClass()).execute();
        setHasOptionsMenu(true);
    }

    public static Context getContextOfApplication(){
        return contextOfApplication;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        contextOfApplication = getActivity().getApplicationContext();
        listView = (ListView) rootView.findViewById(R.id.mobile_list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                //Get item at position
                Book item = (Book) parent.getItemAtPosition(position);

//                //Pass the image title and url to DetailsActivity
//                Intent intent = new Intent(getActivity(), DetailsActivity.class);
//                intent.putExtra("title", item.getTitle());  // toolbar
//                intent.putExtra("image", item.getImage());
//                intent.putExtra("overview", item.getOverview());
//                intent.putExtra("vote", item.getVote());
//                intent.putExtra("release", item.getRelease());

                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                Book mov = new Book(item.getImage(),item.getTitle(), item.getOverview(),
                        item.getVote(),item.getRelease());
                intent.putExtra("mov", mov);
                //Start details activity
                startActivity(intent);
            }
        });

        return rootView;
    }


    @Override
    public void processFinish(ArrayList<Object> strings) {
        if(strings == null){
            Toast.makeText(getActivity().getBaseContext(), "Something went wrong (array is null), please try again!", Toast.LENGTH_SHORT).show();
        }else if(isAdded()){
            //strings = new ArrayList<Book>();
//            ArrayList<Book> variable = (ArrayList<Book>)(List<?>) strings;
//            System.out.println("VYPIS: "+strings.get(0).getClass().getName().toString());

            System.out.println(strings);
//            System.out.println("PRVY "+strings.get(0).getClass().getName().getImage());
//            System.out.println(variable.get(1).getImage());
            adapter = new Adapter(getActivity().getBaseContext() , R.layout.listview_item, strings);
            listView.setAdapter(adapter);
        }
    }

}
