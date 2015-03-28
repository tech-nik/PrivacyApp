package com.example.stegapp;

import java.io.File;

import android.app.IntentService;
import android.content.Intent;

public class HideService extends IntentService 
{
	public static String plaintext;
	private File file;
	

	public HideService() {
		super(HideService.class.getName());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) 
	{
		
		

	}

}
