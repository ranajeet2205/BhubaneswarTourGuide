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
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
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

        final ArrayList<Tour> shoppingList = new ArrayList<Tour>();

        //Add shopping list in the list

        shoppingList.add(new Tour(R.drawable.bhubaneswar_central,getString(R.string.bhubaneswar_central),getString(R.string.bhubaneswar_central_address)));
        shoppingList.add(new Tour(R.drawable.forum_mart,getString(R.string.forum_mart),getString(R.string.forum_mart_address)));
        shoppingList.add(new Tour(R.drawable.pantaloons,getString(R.string.pantaloons),getString(R.string.pantaloons_address)));
        shoppingList.add(new Tour(R.drawable.the_world,getString(R.string.the_world),getString(R.string.the_world_address)));
        shoppingList.add(new Tour(R.drawable.pal_heights,getString(R.string.pal_heights),getString(R.string.pal_heights_address)));
        shoppingList.add(new Tour(R.drawable.bmc_bhawani_mall,getString(R.string.bmc_mall),getString(R.string.bmc_mall_address)));
        shoppingList.add(new Tour(R.drawable.esplanade,getString(R.string.forum_esplanade),getString(R.string.forum_esplanade_address)));



        TourAdapter tourAdapter = new TourAdapter(getActivity(),shoppingList);
        ListView tourList = (ListView)rootView.findViewById(R.id.location_list);
        tourList.setAdapter(tourAdapter);

        tourList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Tour tourItem = shoppingList.get(position);

                //Intent to map

                String map = getString(R.string.google_url) + tourItem.getmLocationAddress() ;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);


            }
        });

        return  rootView;


    }

}
