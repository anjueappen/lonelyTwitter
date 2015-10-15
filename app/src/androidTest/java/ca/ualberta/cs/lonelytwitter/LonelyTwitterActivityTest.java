package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Button saveButton;
    private EditText bodytext;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditTweet(){
        //Calling getActivity will start the app and the activity
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();

        //reset app to a known state
        activity.getTweets().clear();

        //add a tweet using the UI
        bodytext = activity.getBodyText();
        saveButton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodytext.setText("test tweet");
                saveButton.performClick();
            }
        });

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals("test tweet", tweet.getText());

        //click on the tweet to edit
        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetList.getChildAt(0);
                oldTweetList.performItemClick(v, 0, v.getId());
            }
        });

        //ensure the tweet editor activity starts up
        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);

// Validate that ReceiverActivity is started
        EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

// Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);

        //test that the editor starts up with the right tweet

        //test that we can edit that tweet

        //test that we can push some kind of save button

        //the new modified  tweet test was actually saved

        // the new modified tweeet text is displayed on the other activity

        //clean up activities at the end of UI test
        receiverActivity.finish();
    }
}
