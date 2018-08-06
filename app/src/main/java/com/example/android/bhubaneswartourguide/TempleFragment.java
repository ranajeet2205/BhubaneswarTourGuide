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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TempleFragment extends Fragment {


    public TempleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_historical_place, container, false);

        final ArrayList<Tour> TempleList = new ArrayList<Tour>();

        //Add temple list

        TempleList.add(new Tour(R.drawable.lingaraj_temple,getString(R.string.ingaral_temple),getString(R.string.lingaraj_temple_address)));
        TempleList.add(new Tour(R.drawable.brahmeswar_temple,getString(R.string.bramhaswar_temple_address),getString(R.string.bramheswar_temple)));
        TempleList.add(new Tour(R.drawable.rajarani_temple,getString(R.string.rajarani_temple),getString(R.string.rajarani_temple_address)));
        TempleList.add(new Tour(R.drawable.chausathi_jogini_temple,getString(R.string.chausathi_jagini_temple),getString(R.string.chausathi_jogini_temple_address)));
        TempleList.add(new Tour(R.drawable.parshurameswar_temple,getString(R.string.parsurameswar_temple),getString(R.string.parsurameswar_temple_address)));
        TempleList.add(new Tour(R.drawable.rameswar,getString(R.string.rameswar_temple),getString(R.string.rameswar_temple_address)));


        TourAdapter tourAdapter = new TourAdapter(getActivity(),TempleList);
        ListView tourList = (ListView)rootView.findViewById(R.id.location_list);
        tourList.setAdapter(tourAdapter);

        tourList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Tour tourItem = TempleList.get(position);

                //Intent to map

                String map = getString(R.string.google_url) + tourItem.getmLocationAddress() ;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);


            }
        });

        return  rootView;
    }

}
