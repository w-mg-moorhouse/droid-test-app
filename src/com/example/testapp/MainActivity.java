package com.example.testapp;

import java.util.List;

import android.hardware.Camera;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private Camera cam;
	private CameraPreview preview;
	private LocationScan wifi;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		wifi = new LocationScan();
		cam = MainActivity.getCameraInstance();
		preview = new CameraPreview(this, cam);
		FrameLayout prev = (FrameLayout) findViewById(R.id.camera_preview);
        prev.addView(preview);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void click(View view)
	{
		Toast.makeText(this, "Button 1 pressed",
		Toast.LENGTH_LONG).show();
		wifi.addScan();

	}
	
	/** A safe way to get an instance of the Camera object. */
	public static Camera getCameraInstance(){
		Camera cam = null;
	    try {
	        cam = Camera.open(); // attempt to get a Camera instance
	        cam.setParameters(cam.getParameters());
	    }
	    catch (Exception e){
	        // Camera is not available (in use or does not exist)
	    }
	    return cam; // returns null if camera is unavailable
	}

}
