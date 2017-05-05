package com.example.gabor.mylibrary;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<Object> {
    private Context context;
    private final LayoutInflater mInflater;
    int resource;
    ArrayList<Object> books = new ArrayList<>();

    public Adapter(Context context, int resource , ArrayList<Object> objects) {
        super(context,  resource, objects);

        this.context=context;
        this.resource=resource;

        //ArrayList<Book> variable = (ArrayList<Book>)(List<?>) objects;
        

        books = objects;
        mInflater = LayoutInflater.from(context);
    }


    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView picture;
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            convertView.setTag(R.id.picture, convertView.findViewById(R.id.picture));

            convertView.setTag(R.id.textView, convertView.findViewById(R.id.textView));

            holder = new ViewHolder();
            holder.imageview = (ImageView) convertView.findViewById(R.id.picture);
            holder.titleview = (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Book book = null;
        if(books.get(0).getClass() == Book.class) {
            ArrayList<Book> variable = (ArrayList<Book>)(List<?>) books;
            book = variable.get(position);
        }

        //Log.v("IDEEEEEEEEEEE url", movie.getImage());
        //Log.v("Titles", movie.getTitle());
        Picasso.with(context)
                .load(book.getImage())
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .into(holder.imageview);

        holder.titleview.setText(book.getTitle());


        return convertView;

//        picture = (ImageView) convertView.getTag(R.id.picture);
//        picture.setImageResource(mThumbIds[position]);
//        return convertView;
    }


    static class ViewHolder  {
        public ImageView imageview;
        public TextView titleview;

    }

}