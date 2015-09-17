package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anju on 16/09/15.
 */
public class ImportantTweet extends Tweet{
    public ImportantTweet(String tweet, Date date) {
        super(tweet, date);
        this.setTweet(tweet);
        this.date = date;
    }

    public ImportantTweet(String tweet) {
        super(tweet);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override
    public String getText() {
        return "!!!" + super.getText();
    }
    }

