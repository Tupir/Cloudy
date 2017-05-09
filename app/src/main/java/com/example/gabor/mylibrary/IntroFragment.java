package com.example.gabor.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class IntroFragment extends Fragment implements AsyncResponse{

    public static Context contextOfApplication;
    Adapter adapter;
    ListView listView;
    private TextView titleTextView;
    //   private ImageView imageView;

//    @Bind(R.id.textView2)
//    TextView textOverview;

    public static String [] prgmNameList={" PETER GABOR", " VERONIKA FRICOVA", " JAN NEJAN", " JOZKO MRKVA"};
    ListView lv;
    Context context;

    ArrayList prgmName;

    public IntroFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        context=getActivity();
//
//        ButterKnife.bind(getActivity()); // before setText
//        //butt.setText("VISIT");
//        lv.setAdapter(new IntroFragment.CustomAdapter(this, prgmNameList));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_intro, container, false);
        View rootView = inflater.inflate(R.layout.fragment_intro, container, false);



        contextOfApplication = getActivity().getApplicationContext();
//        listView = (ListView) rootView.findViewById(R.id.lvLocations);

        return rootView;
    }


    @Override
    public void processFinish(ArrayList<Object> strings) {
//        if(strings == null){
//            Toast.makeText(getActivity().getBaseContext(), "Something went wrong (array is null), please try again!", Toast.LENGTH_SHORT).show();
//        }else if(isAdded()){
//
//            System.out.println(strings);
//            adapter = new Adapter(getActivity().getBaseContext() , R.layout.listview_item1, strings);
//            listView.setAdapter(adapter);
//        }
    }


//
//
//    public class CustomAdapter extends BaseAdapter {
//        String [] result;
//        Context context;
//        int [] imageId;
//        private LayoutInflater inflater=null;
//        public CustomAdapter(IntroFragment mainActivity, String[] prgmNameList) {
//            result=prgmNameList;
//            context=mainActivity.getActivity();
//            inflater = ( LayoutInflater )context.
//                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        }
//        @Override
//        public int getCount() {
//            return result.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return position;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        public class Holder
//        {
//            TextView tv;
//            ImageView img;
//        }
//        @Override
//        public View getView(final int position, View convertView, ViewGroup parent) {
//            IntroFragment.CustomAdapter.Holder holder=new IntroFragment.CustomAdapter.Holder();
//            View rowView;
//            //rowView = inflater.inflate(R.layout.listview_item, null);
//            rowView = inflater.inflate(R.layout.listview_item1, null);
//            holder.tv=(TextView) rowView.findViewById(R.id.textView11);
//            holder.tv.setText(result[position]);
//            return rowView;
//        }
//
//    }


}
