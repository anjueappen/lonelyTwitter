package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anju on 16/09/15.
 */
public abstract class Mood {

    private String mood;
    private Date date;

    public Mood(String mood) {
        this.date = new Date();
        setMood(mood);
    }

    public Mood(String mood, Date date) {
        setMood(mood);
        this.date = date;
    }

    public String getMood() {

        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract void actOnMood();
}
