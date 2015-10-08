package ca.ualberta.cs.lonelytwitter;


/**
 * Created by anju on 07/10/15.
 */
public interface MyObservable {
    void addObserver(MyObserver o);
    void notifyObservers(); //just to tell the lookers
}
