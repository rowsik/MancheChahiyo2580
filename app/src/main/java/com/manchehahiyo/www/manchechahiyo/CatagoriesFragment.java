package com.manchehahiyo.www.manchechahiyo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Ratan on 7/29/2015.
 */
public class CatagoriesFragment extends Fragment {
    LinearLayout linearLayout1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.catagories_layout,null);
        linearLayout1= (LinearLayout) view.findViewById(R.id.linearlayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PhotographyFragment.class);
                startActivity(intent);
            }
        });

        return  view;


    }
}