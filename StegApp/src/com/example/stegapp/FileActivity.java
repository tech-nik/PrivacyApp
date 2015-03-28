package com.example.stegapp;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FileActivity extends ListActivity 
{

	private File currentDir;
	private FileArrayAdapter adapter;
	public Intent intent;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		//Toast.makeText(getApplicationContext(), "oncreate()", Toast.LENGTH_SHORT).show();
		//setContentView(R.layout.fileactivity);
		getListView().setBackgroundResource(R.drawable.photo);
		super.onCreate(savedInstanceState);
		currentDir = new File("/sdcard/");
		intent = getIntent();
		fill(currentDir);
		//Toast.makeText(getApplicationContext(), "FileActivity Created : "+getIntent().getExtras().getString("chosenbtn"), Toast.LENGTH_LONG).show();
		
	}
	
	
	
	private void fill (File f)
	{
		File[] dirs = f.listFiles();
		this.setTitle("Current Dir : "+f.getName());
		List<Option> dir = new ArrayList<Option>();
		List<Option> fls = new ArrayList<Option>();
		
		
		
		try
		{
			for(File ff : dirs)
			{
				if(ff.isDirectory())
				{
					dir.add(new Option(ff.getName(), "Folder", ff.getAbsolutePath()));
				}
				else
				{
					fls.add(new Option(ff.getName(),"File Size : "+ff.length(),ff.getAbsolutePath()));
				}
			}
		}
		
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), "Error in adding files and dirs to list", Toast.LENGTH_LONG).show();
		}
		
		Collections.sort(dir);
		Collections.sort(fls);
		dir.addAll(fls);
		
		if(!f.getName().equalsIgnoreCase("sdcard"))
		{
			dir.add(0,new Option("..","Parent Directory",f.getParent()));
		}
		
		adapter = new FileArrayAdapter(FileActivity.this,R.layout.fileactivity ,dir);
		this.setListAdapter(adapter);
		
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);
		Option o = adapter.getItem(position);
		if(o.getData().equalsIgnoreCase("folder")||o.getData().equalsIgnoreCase("parent directory"))
		{
			currentDir = new File(o.getPath());
			fill(currentDir);
		}
		else
		{
			onFileClick(o);
		}
	}
	
	private void onFileClick(Option o)
	{
		
		//add the filename and path to extra and move on to next activity based on the radio button selected
		//intent.putExtra("filename", o.getPath());
		String selection = intent.getExtras().getString("chosenbtn");
		if(selection.equalsIgnoreCase("hide"))
		{
			//go to hideactivty
			intent = new Intent(this,HideActivity.class);
			intent.setAction("com.example.stegapp.HideActivty");
			intent.putExtra("filename",o.getPath());
			startActivity(intent);
			
		}
		else
		{
			//go to reveal activity
			intent = new Intent(this,RevealActivity.class);
			intent.setAction("com.example.stegapp.RevealActivity");
			intent.putExtra("filename", o.getPath());
		}
		
		
		
	}
	

}
