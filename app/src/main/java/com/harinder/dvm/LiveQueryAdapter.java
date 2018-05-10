package com.harinder.dvm;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LiveQueryAdapter extends ArrayAdapter<LiveQueryItem> {

    public LiveQueryAdapter(Context context, List<LiveQueryItem> objects) {
        super(context,0, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view= convertView;
        if(view==null)
        {
            view= LayoutInflater.from(getContext()).inflate(R.layout.livequeriesitem, parent, false);

        }

        LiveQueryItem currentItem=getItem(position);

        CircleImageView circleImageView= view.findViewById(R.id.profile);
        TextView name=(TextView) view.findViewById(R.id.liveCropName);

        name.setText(currentItem.getCrop());
        circleImageView.setImageResource(currentItem.getId());

        return view;
    }
}
