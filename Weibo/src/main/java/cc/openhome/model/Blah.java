package cc.openhome.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhujie on 16/2/14.
 */
public class Blah implements Serializable {
    private String username;
    private Date date;
    private String txt;

    public Blah() {
    }

    public Blah(String username, Date date, String txt) {
        this.username = username;
        this.date = date;
        this.txt = txt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
