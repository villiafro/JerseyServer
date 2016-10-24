package models;

/**
 * Created by VilhjalmurAlex on 24/10/2016.
 */
public class Videos {
    private int Id;
    private String Url;
    private int UserId;

    public Videos(int id, String url, int uid){
        this.Id = id;
        this.Url = url;
        this.UserId = uid;
    }
}
