package com.example.features;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

public class ProjectPage extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Context cont = this;
		final int N = 21; // the number of projects of the user
		LinearLayout lay = new LinearLayout(this);
		LinearLayout parentLay = new LinearLayout(this);
		parentLay.setOrientation(LinearLayout.VERTICAL);
        ScrollView scroll = new ScrollView(this);
        scroll.addView(parentLay);
        parentLay.addView(lay);
        lay.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout lay1 = new LinearLayout(this);
        LinearLayout lay2 = new LinearLayout(this);
        lay1.setOrientation(LinearLayout.VERTICAL);
        lay2.setOrientation(LinearLayout.VERTICAL);
        lay1.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
        lay2.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
        lay.addView(lay1);
        lay.addView(lay2);
        Button button = new Button(this);
        button.setWidth(400);
        button.setHeight(400);
        button.setText("Create new Project");
        parentLay.addView(button);
        final TextView[] myTextViews = new TextView[N]; // create an empty array;

        for (int i = 0; i < N; i++) {
            // create a new textview
        	if(i < N/2){
            final Button rowTextView = new Button(this);
            rowTextView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(cont, Project.class);
			    	//Check his credentials and print error to id error
			    	startActivity(intent);
				}
			});
            // set some properties of rowTextView or something
            rowTextView.setText(""+i);
            rowTextView.setWidth(400);
            rowTextView.setHeight(400);
            lay1.addView(rowTextView);
            // save a reference to the textview for later
            myTextViews[i] = rowTextView;
        	}
        	else{
        		final Button rowTextView = new Button(this);
        		rowTextView.setText(""+i);
                lay2.addView(rowTextView);
                rowTextView.setWidth(400);
                rowTextView.setHeight(400);
                myTextViews[i] = rowTextView;
                rowTextView.setOnClickListener(new OnClickListener() {
    				
    				@Override
    				public void onClick(View v) {
    					Intent intent = new Intent(cont, Project.class);
    			    	//Check his credentials and print error to id error
    			    	startActivity(intent);
    				}
    			});
                
        	}
        }
        setContentView(scroll);
		//setContentView(R.layout.activity_project_page);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.project_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
