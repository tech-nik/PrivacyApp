package com.example.stegapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class StegActivity extends Activity {

	private RadioGroup choice;
	private RadioButton chosenbtn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//Toast.makeText(getApplicationContext(), "StegaActivity created", Toast.LENGTH_LONG).show();
		setContentView(R.layout.stegactivity);
		super.onCreate(savedInstanceState);

		
		
	}
	
	public void startFileActivity(View v) 
	{
		
		
		choice = (RadioGroup)findViewById(R.id.radiogroup_choice);
		chosenbtn = (RadioButton)findViewById(choice.getCheckedRadioButtonId());		
		Intent intent = new Intent(this,FileActivity.class);
		intent.setAction("com.example.stegapp.FileActivity");
		
		intent.putExtra("chosenbtn",chosenbtn.getText());
		startActivity(intent);
		
		Toast.makeText(getApplicationContext(), "Choose an audio file.", Toast.LENGTH_LONG).show();
	
		
		
	}
	
	

}
