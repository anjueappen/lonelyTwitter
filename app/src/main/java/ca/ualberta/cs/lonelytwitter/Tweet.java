package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by anju on 16/09/15.
 */
public abstract class Tweet implements Tweetable{
    private String tweet;
    protected Date date;
    private ArrayList<Mood> moods; 

    public void setTweet(String tweet) throws IllegalArgumentException{
        if (tweet.length() <= 140){
            this.tweet = tweet;
        }else{
            throw new IllegalArgumentException("Tweet is too long!");
        }

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return tweet;
    }

    public Date getDate() {
        return date;
    }

    public Tweet(String tweet, Date date) {
        this.setTweet(tweet);
        this.date = date;
    }
    public Tweet(String tweet) {
        this.setTweet(tweet);
        this.date = new Date();
    }

    public abstract Boolean isImportant();

    @Override
    public String toString(){
        return date.toString() + " || " + this.tweet.toString();
    }


}
