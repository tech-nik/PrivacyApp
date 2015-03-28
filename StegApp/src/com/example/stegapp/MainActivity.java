package com.example.stegapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		//Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
	}
	
	public void startStegActivity(View view)	{
		Intent intent = new Intent(this,StegActivity.class);
		intent.setAction("com.example.stegapp.StegActivity");
		startActivity(intent);
		Toast.makeText(getApplicationContext(), "Hide or Reveal?", Toast.LENGTH_LONG).show();
		
		
		
	}
	
	public void startPicActivty(View view)
	{
		Intent intent = new Intent(this,PicActivity.class);
		intent.setAction("com.example.stegapp.PicActivity");
		startActivity(intent);
		
		//choose a pic from gallery
		//display it full screen and listen for touch at a point
		//save the coordinates of that point
	}
	
	public void startAppActivity(View view)
	{
		//show a list of all installed apps
		//when clicked on 1 app, show the permissions that app uses
		Intent intent = new Intent(this,AppActivity.class);
		intent.setAction("com.example.stegapp.AppActivity");
		startActivity(intent);
		
	}
	
	
	

}
