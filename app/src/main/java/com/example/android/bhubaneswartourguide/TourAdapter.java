package com.example.android.bhubaneswartourguide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TourAdapter extends ArrayAdapter<Tour> {

    public TourAdapter(Activity context, ArrayList<Tour>TourArrayList) {

        super(context, 0,TourArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        Tour getTourItem = getItem(position);

        //Add image to the appropriate id

        ImageView locationImage =(ImageView) listItemView.findViewById(R.id.location_image);
        locationImage.setImageResource(getTourItem.getmLoctionImage());

        //Add location name to the appropriate id

        TextView locationText = (TextView)listItemView.findViewById(R.id.location_text);
        locationText.setText(getTourItem.getmLocationName());

        //Add location address to the appropriate id

        TextView locationAddress=(TextView)listItemView.findViewById(R.id.location_address);
        locationAddress.setText(getTourItem.getmLocationAddress());



        return listItemView;
    }
}
