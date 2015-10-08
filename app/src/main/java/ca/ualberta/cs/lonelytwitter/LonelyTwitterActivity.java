package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav"; //model
	private EditText bodyText; //model
	private ListView oldTweetsList; //model
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
        ArrayList<Tweet> tweetList = new ArrayList<Tweet>(); //model

		Tweet importantTweet = new ImportantTweet("");
        try {
            importantTweet.setTweet("Hah!"); //controller
        }catch (IllegalArgumentException e){
            throw new RuntimeException(e);
        }
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);//view

		bodyText = (EditText) findViewById(R.id.body); //model
		Button saveButton = (Button) findViewById(R.id.save); //controller
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); //view

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK); //model
				String text = bodyText.getText().toString(); //model
				saveInFile(text, new Date(System.currentTimeMillis())); //controller
				finish(); //controller 

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart(); //view
		String[] tweets = loadFromFile(); //model
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets); //controller
		oldTweetsList.setAdapter(adapter); //controller
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>(); //model
		try {
			FileInputStream fis = openFileInput(FILENAME); //controller
			BufferedReader in = new BufferedReader(new InputStreamReader(fis)); //controller
			String line = in.readLine(); //model
			while (line != null) {
				tweets.add(line); //controller
				line = in.readLine(); //controller
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]); //model
	}
	
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}