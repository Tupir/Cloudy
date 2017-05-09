package com.example.gabor.mylibrary;

import android.app.ListActivity;
import android.content.Context;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {
    private TextView titleTextView;
    //   private ImageView imageView;

    @Bind(R.id.overview)
    TextView textOverview;
    @Bind(R.id.vote)
    TextView textVote;
//    @Bind(R.id.release)
//    TextView textRelease;
    @Bind(R.id.imageView1)
    ImageView imageView;
    public static String [] prgmNameList={"Peter GABOR: Nic pre mna, strata casu","Veronika FRICOVA: Este som ju necitala ale chystam sa, mate nejake rady?",
            "Jozko MRKVA: Urcite skus! Najlepsia kniha aku som kedy cital. Uz netrpezlivo cakam na nove casti",};
    ListView lv;
    Context context;

    ArrayList prgmName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList));


        Book mov = getIntent().getParcelableExtra("mov");

        ButterKnife.bind(this); // before setText

        if (mov != null) {
            textOverview.setText(mov.getTitle()+"\nPages: "+ mov.getOverview()+"\nPublish year: 2016");
            //textVote.setText(mov.getVote() + "/10.00");
            //textRelease.setText(mov.getRelease());
            getSupportActionBar().setTitle(mov.getTitle());
            Picasso.with(this)
                    .load(mov.getImage())
                    .placeholder(R.drawable.no_image)
                    .error(R.drawable.no_image)
                    .into(imageView);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for back button

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            // Respond to the action bar's Up/Home button
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }



    public class CustomAdapter extends BaseAdapter {
        String [] result;
        Context context;
        int [] imageId;
        private LayoutInflater inflater=null;
        public CustomAdapter(DetailsActivity mainActivity, String[] prgmNameList) {
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
            Holder holder=new Holder();
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