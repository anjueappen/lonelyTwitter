package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anju on 16/09/15.
 */
public class Sad extends Mood {
    public Sad(String mood, Date date) {
        super(mood, date);
    }

    public Sad(String mood) {
        super(mood);
    }

    @Override
    public void actOnMood(){
        System.out.println("**Tear Drop rolls down cheek.**");
    }
}
