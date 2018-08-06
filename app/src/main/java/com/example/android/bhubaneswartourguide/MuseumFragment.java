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
public class MuseumFragment extends Fragment {


    public MuseumFragment() {
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

        final ArrayList<Tour> museumList = new ArrayList<Tour>();

        //Add museum list in the list

        museumList.add(new Tour(R.drawable.regional_museum,getString(R.string.regional_museum),getString(R.string.regional_museum_address)));
        museumList.add(new Tour(R.drawable.museum_of_tribal_arts,getString(R.string.tribal_museum),getString(R.string.tribal_museum_address)));
        museumList.add(new Tour(R.drawable.state_museum,getString(R.string.odisha_state_museum),getString(R.string.odisha_state_museum_address)));
        museumList.add(new Tour(R.drawable.state_craft_museum,getString(R.string.odisha_craft_museum),getString(R.string.odisha_craft_museum_address)));
        museumList.add(new Tour(R.drawable.orient_craft_museum,getString(R.string.orient_craft_museum),getString(R.string.orient_craft_museum_address)));
        museumList.add(new Tour(R.drawable.kala_bhoomi_museum,getString(R.string.kala_bhoomi_museum),getString(R.string.kala_bhoomi_museum_address)));



        TourAdapter tourAdapter = new TourAdapter(getActivity(),museumList);
        ListView tourList = (ListView)rootView.findViewById(R.id.location_list);
        tourList.setAdapter(tourAdapter);

        tourList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Tour tourItem = museumList.get(position);

                //Intent to map

                String map = getString(R.string.google_url) + tourItem.getmLocationAddress() ;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);


            }
        });

        return  rootView;
    }

}
