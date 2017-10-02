package com.example.android.mytodo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shruti on 09-09-2017.
 */

public class customAdapter extends ArrayAdapter<schedules> {
    Context mContext;
    ArrayList<schedules> mItems;

     public customAdapter(@NonNull Context context, ArrayList<schedules> schedule){
         super(context,0);
         mContext = context;
         mItems = schedule;
     }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
             convertView = LayoutInflater.from(mContext).inflate(R.layout.row_layout,null);
            viewHolder vHolder = new viewHolder();
         vHolder.title =   (TextView)convertView.findViewById(R.id.title);
vHolder.description =   (TextView)convertView.findViewById(R.id.rowTextView);
convertView.setTag(vHolder);
        }

        viewHolder vholder  = (viewHolder) convertView.getTag();




        schedules item = mItems.get(position);
       vholder.title.setText(item.getTitle());
        vholder.description.setText(item.getDescription());




return convertView;
    }

static class viewHolder {
    TextView title;
    TextView description;
}}