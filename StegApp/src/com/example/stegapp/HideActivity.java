package com.example.stegapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HideActivity extends Activity 
{
	
	Intent intent;
	Button btn;
	EditText txt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		setContentView(R.layout.hideactivity);
		super.onCreate(savedInstanceState);
		intent = getIntent();
		btn = (Button) findViewById(R.id.btn_starthideservice);
		txt = (EditText) findViewById(R.id.editText1);
		
		
	}
	
	public void startHideService(View v)
	{
		
		Intent workIntent = new Intent(this,HideService.class);
		HideService.plaintext = txt.getText().toString();
		workIntent.putExtra("filename", intent.getExtras().getString("filename"));
		intent.setAction("com.example.stegapp.HideService");
		startActivity(workIntent);
	
		
	}
	

}
