package com.example.jag43.blindhattest;

/**
 * Created by jag43 on 2/14/2017.
 */

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;

public abstract class gps extends Activity implements LocationListener {

    
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        mBluetoothAdapter = new BluetoothAdapter.getDefaultAdapter();
        if(mbluetoothAdapter == null)
        {
            //device does not support bluetooth
        }

        if(mBluetoothAdapter.isEnabled())
        {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 1);
        }

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        if(pairedDevices.size() > 0)
        {
            for(BluetoothDevice device : pairedDevices)
            {
                mdevice = device;
            }
        }
    }

    @Override
   public void onLocationChanged(Location location)
   {
       double latitude = (double) (location.getLatitude());
       double longitude = (double) (location.getLongitude());

       Log.i("Geo_Location", "Latitude: "+latitude+", Longitude: "+longitude);
       System.out.print(latitude);
       System.out.print(longitude);
   }

    @Override
    public void onProviderDisabled(String provider)
    {

    }

    @Override
    public void onProviderEnabled(String provider)
    {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }

}
