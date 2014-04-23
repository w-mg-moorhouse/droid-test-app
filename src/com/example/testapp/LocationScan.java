package com.example.testapp;

import java.util.List;

import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

public class LocationScan
{
	private WifiManager wifi;
	private LocationManager gps;
	
	public Boolean addScan()
	{
		gps.
		wifi.startScan();
		if (wifi.isWifiEnabled())
	    {
	    	List <ScanResult> results = wifi.getScanResults(); 
	    	for(ScanResult res : results)
	    	{
	    		
	    		Log.i("wifiScan", res.SSID);
	    		//results parsing.
	    	}        	
	    }
		else
		{
			
			return false;
		}
		return true;
	}
	
}
