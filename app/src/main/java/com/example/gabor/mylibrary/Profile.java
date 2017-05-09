package com.example.gabor.mylibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Profile extends AppCompatActivity {
    private TextView titleTextView;
    //   private ImageView imageView;

//    @Bind(R.id.textView2)
//    TextView textOverview;

    public static String [] prgmNameList={" PETER GABOR", " VERONIKA FRICOVA", " JAN NEJAN", " JOZKO MRKVA"};
    ListView lv;
    Context context;

    ArrayList prgmName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        context=this;

        lv=(ListView) findViewById(R.id.listView2);
        lv.setAdapter(new Profile.CustomAdapter(this, prgmNameList));

        ButterKnife.bind(this); // before setText
        //butt.setText("VISIT");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for back button


    }



    public class CustomAdapter extends BaseAdapter {
        String [] result;
        Context context;
        int [] imageId;
        private LayoutInflater inflater=null;
        public CustomAdapter(Profile mainActivity, String[] prgmNameList) {
            result=prgmNameList;
            context=mainActivity;
            inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return result.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public class Holder
        {
            TextView tv;
            ImageView img;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            Profile.CustomAdapter.Holder holder=new Profile.CustomAdapter.Holder();
            View rowView;
            //rowView = inflater.inflate(R.layout.listview_item, null);
            rowView = inflater.inflate(R.layout.listview_item1, null);
            holder.tv=(TextView) rowView.findViewById(R.id.textView11);
            holder.tv.setText(result[position]);
//            rowView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
//                }
//            });
            return rowView;
        }

    }

}
