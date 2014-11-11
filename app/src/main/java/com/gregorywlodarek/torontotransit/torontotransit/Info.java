package com.gregorywlodarek.torontotransit.torontotransit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Info tab.
 *
 * @version 1.0
 * @author Grzegorz Wlodarek
 */
public class Info extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View info = inflater.inflate(R.layout.info_frag, container, false);

        //TextView infoText = (TextView) info.findViewById(R.id.te);

        //Button teamButton = (Button) info.findViewById(R.id.teamButton);
        Button mapButton = (Button) info.findViewById(R.id.subwayButton);
        //Button instructionsButton = (Button) info.findViewById(R.id.instructionsButton);
        Button ttcAlertsButton = (Button) info.findViewById(R.id.ttcAlertsButton);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Info.this.getActivity(), SubwayMap.class);
                startActivity(i);
            }
        });

        /*
        teamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Info.this.getActivity(), TheTeam.class);
                startActivity(i);
            }
        });


        instructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Info.this.getActivity(), Instructions.class);
                startActivity(i);
            }
        });
        */

        ttcAlertsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Info.this.getActivity(), TTCAlerts.class);
                startActivity(i);
            }
        });


        return info;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }
}