package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anju on 16/09/15.
 */
public class Happy extends Mood {

    @Override
    public void actOnMood(){
        System.out.println("**Fist Pump**");
    }

    public Happy(String mood) {
        super(mood);
    }

    public Happy(String mood, Date date) {
        super(mood, date);
    }
}
