package com.example.gabor.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Intro extends AppCompatActivity {
    private TextView titleTextView;
    //   private ImageView imageView;

//    @Bind(R.id.textView2)
//    TextView textOverview;

    public static String [] prgmNameList={" PETER GABOR", " JAN NEJAN", " JOZKO MRKVA"};
    public static String [] prgmNameList1={"3 NEW!", "1 NEW!", "7 NEW!"};
    ListView lv;
    Context context;

    ArrayList prgmName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context=this;

        lv=(ListView) findViewById(R.id.lvLocations);
        lv.setAdapter(new Intro.CustomAdapter(this, prgmNameList, prgmNameList1));

//        ButterKnife.bind(this); // before setText
        //butt.setText("VISIT");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for back button

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }

        if (id == R.id.action_profile) {
            startActivity(new Intent(this, Profile.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class CustomAdapter extends BaseAdapter {
        String [] result;
        String [] result1;
        Context context;
        int [] imageId;
        private LayoutInflater inflater=null;
        public CustomAdapter(Intro mainActivity, String[] prgmNameList, String[] prgmNameList1) {
            result=prgmNameList;
            result1 = prgmNameList1;
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
            Intro.CustomAdapter.Holder holder=new Intro.CustomAdapter.Holder();
            View rowView;
            //rowView = inflater.inflate(R.layout.listview_item, null);
            rowView = inflater.inflate(R.layout.listview_item2, null);
            holder.tv=(TextView) rowView.findViewById(R.id.textView55);
            holder.tv.setText(result[position]);
            holder.tv=(TextView) rowView.findViewById(R.id.textView56);
            holder.tv.setText(result1[position]);

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
