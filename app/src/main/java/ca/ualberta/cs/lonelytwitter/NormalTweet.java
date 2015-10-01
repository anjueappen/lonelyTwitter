package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by anju on 16/09/15.
 */
public class NormalTweet extends Tweet {
    public NormalTweet(String tweet, Date date) {
        super(tweet, date);
    }


    public NormalTweet(String tweet) {
        super(tweet);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

}
