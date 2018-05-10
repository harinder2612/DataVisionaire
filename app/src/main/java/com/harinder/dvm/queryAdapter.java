package com.harinder.dvm;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class queryAdapter extends ArrayAdapter<queryItemClass> {


    public queryAdapter(Context context, List<queryItemClass> objects) {
        super(context,0, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view= convertView;
        if(view==null)
        {
            view= LayoutInflater.from(getContext()).inflate(R.layout.queriesitem, parent, false);

        }

        queryItemClass currentItem=getItem(position);
        TextView cropname=(TextView) view.findViewById(R.id.cropName);
        TextView activemonths=(TextView) view.findViewById(R.id.activeMonths);
        TextView time=(TextView) view.findViewById(R.id.LoadTime);
        TextView results=(TextView) view.findViewById(R.id.result);

        cropname.setText(currentItem.getCropName());
        activemonths.setText(currentItem.getActiveMonths());
        time.setText(currentItem.getTime());
        results.setText(currentItem.getResults());

        return view;
    }
}
