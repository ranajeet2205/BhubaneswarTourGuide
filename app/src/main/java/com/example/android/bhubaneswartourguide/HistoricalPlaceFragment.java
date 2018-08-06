package com.example.android.bhubaneswartourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class HistoricalPlaceFragment extends Fragment {



    public HistoricalPlaceFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_historical_place, container, false);

        final ArrayList<Tour> historicalPlaceList = new ArrayList<Tour>();


        //Add Historicalplace in the list

        historicalPlaceList.add(new Tour(R.drawable.dhauli_giri_hills,getString(R.string.dhauli_giri_hill),getString(R.string.dhauli_gir_address)));
        historicalPlaceList.add(new Tour(R.drawable.godavai_pond,getString(R.string.godavari_pond),getString(R.string.godavari_pond_address)));
        historicalPlaceList.add(new Tour(R.drawable.khandagiri_caves,getString(R.string.khandagiri_caves),getString(R.string.khandagiri_cave_address)));
        historicalPlaceList.add(new Tour(R.drawable.panchu_pandva_caves,getString(R.string.panchu_pandava_caves),getString(R.string.panchu_pandava_caves_address)));
        historicalPlaceList.add(new Tour(R.drawable.sisupalgarh,getString(R.string.sisupalgarh),getString(R.string.sisupalgarh_address)));
        historicalPlaceList.add(new Tour(R.drawable.udaygiri_caves,getString(R.string.udayagiri_caves),getString(R.string.udayagiri_address)));


        TourAdapter tourAdapter = new TourAdapter(getActivity(),historicalPlaceList);
        ListView tourList = (ListView)rootView.findViewById(R.id.location_list);
        tourList.setAdapter(tourAdapter);


        //onitemClickLIstener

        tourList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Tour tourItem = historicalPlaceList.get(position);

                //Intent to map

                String map = getString(R.string.google_url) + tourItem.getmLocationAddress() ;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);


            }
        });



        return  rootView;
    }





}
