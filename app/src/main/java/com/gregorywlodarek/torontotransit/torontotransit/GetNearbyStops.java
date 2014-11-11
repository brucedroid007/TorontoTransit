package com.gregorywlodarek.torontotransit.torontotransit;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Finds the nearby stops within 300m of the users location.
 *
 * @version 1.0
 * @author Grzegorz Wlodarek
 */
public class GetNearbyStops {
    private ArrayList<String> stops = new ArrayList<String>();
    private ArrayList<String> nearbyStop = new ArrayList<String>();
    private static MainActivity context = null;


    public GetNearbyStops(ArrayList<String> data) {
        this.stops = data;
        
    }

    public void getStops() {
        runTime rt = new runTime();
        if (rt.getStatus() != AsyncTask.Status.RUNNING) {
            rt.execute();
        }
    }
    
    public static void setNewContext(MainActivity c) {
        context = c;
    }

    //Thread to run in background
    private class runTime extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            //Distance to get stops within: 300m.
            float MAXIMUM_DISTANCE = 0.3f;
            //String locationProvider = LocationManager.NETWORK_PROVIDER;
            LocationManager lm = (LocationManager) context.getSystemService(
                    Context.LOCATION_SERVICE);
            //Location lastKnownLocation = lm.getLastKnownLocation(locationProvider);
            Location lastKnownLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastKnownLocation == null) {
                lastKnownLocation = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }

            if (lastKnownLocation != null) {
                double userLatitude = lastKnownLocation.getLatitude();
                double userLongitude = lastKnownLocation.getLongitude();
                double earthRadius = 6371; //kilometers

                for (String s : stops) {
                    String[] sList = s.split("\\|");
                    double sLat = Double.parseDouble(sList[2]);
                    double sLong = Double.parseDouble(sList[3]);

                    double sDLat = Math.toRadians(userLatitude - sLat);
                    double sDLng = Math.toRadians(userLongitude - sLong);
                    double sSindLat = Math.sin(sDLat / 2);
                    double sSindLng = Math.sin(sDLng / 2);
                    double sa = Math.pow(sSindLat, 2) + Math.pow(sSindLng, 2) * Math.cos(Math.toRadians(
                            userLatitude) * Math.cos(Math.toRadians(sLat)));
                    double sc = 2 * Math.atan2(Math.sqrt(sa), Math.sqrt(1 - sa));
                    float sDist = (float) (earthRadius * sc);
                    //System.out.println(sDist + "\n" + sList[1]);

                    if (sDist <= MAXIMUM_DISTANCE) {
                        nearbyStop.add(s);
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
                NearbyResults.createNearbyResults().setData(new ArrayList<String>(nearbyStop));
                NearbyResults.createNearbyResults().executeFromGetStops();
        }
    }

}
