package com.example.android.bhubaneswartourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_historical_place, container, false);

        final ArrayList<Tour> restaurantPlaceList = new ArrayList<Tour>();

        //Add restaurant in the list

        restaurantPlaceList.add(new Tour(R.drawable.silver_strix,getString(R.string.silver_streax),getString(R.string.silver_streax_address)));
        restaurantPlaceList.add(new Tour(R.drawable.taste_of_china,getString(R.string.taste_of_china),getString(R.string.taste_of_china_address)));
        restaurantPlaceList.add(new Tour(R.drawable.mainland_china,getString(R.string.mainland_china),getString(R.string.mainland_china_address)));
        restaurantPlaceList.add(new Tour(R.drawable.yummies,getString(R.string.yummies),getString(R.string.yummies_address)));
        restaurantPlaceList.add(new Tour(R.drawable.the_chef,getString(R.string.the_chef),getString(R.string.the_chef_address)));
        restaurantPlaceList.add(new Tour(R.drawable.lemon_grass,getString(R.string.lemon_grass),getString(R.string.lemon_grass_address)));


        TourAdapter tourAdapter = new TourAdapter(getActivity(),restaurantPlaceList);
        ListView tourList = (ListView)rootView.findViewById(R.id.location_list);
        tourList.setAdapter(tourAdapter);

        tourList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Tour tourItem = restaurantPlaceList.get(position);

                //Intent to map

                String map = getString(R.string.google_url)+ tourItem.getmLocationAddress() ;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);


            }
        });

        return  rootView;
    }

}
