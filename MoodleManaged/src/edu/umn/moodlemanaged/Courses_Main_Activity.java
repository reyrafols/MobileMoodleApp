package edu.umn.moodlemanaged;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Courses_Main_Activity extends Activity {
	ListView coursesList;
	CourseCustomAdapter courseAdapter;
	ArrayList<String> courseArray = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle(R.string.title_activity_main);
		
		/**
		 * Add Courses
		 */
		courseArray.add("CSCI 5801 Software Engineering I");
		courseArray.add("GCD 3022 Genetics");
		courseArray.add("CSCI 3081W Program Design");
		courseArray.add("CSCI 5115 UI");
		
		/**
		  * set item into adapter
		  */
		courseAdapter = new CourseCustomAdapter(Courses_Main_Activity.this, R.layout.course_view_row, courseArray);
		coursesList = (ListView) findViewById(R.id.listView);
		coursesList.setItemsCanFocus(false);
		coursesList.setAdapter(courseAdapter);
		/**
		  * get on item click listener
		  */
		coursesList.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View v, final int position, long id) {
			Log.i("List View Clicked", "**********");
		    Toast.makeText(Courses_Main_Activity.this, "List View Clicked:" + position, Toast.LENGTH_LONG).show();
		   }
		});
	}	
}