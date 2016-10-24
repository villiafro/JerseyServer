package models;

/**
 * Created by VilhjalmurAlex on 24/10/2016.
 */
public class Favourites {
    private int UserId;
    private int VideoId;

    public Favourites(int uid, int vid){
        this.UserId = uid;
        this.VideoId = vid;
    }
}
