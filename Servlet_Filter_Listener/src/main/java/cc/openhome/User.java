package cc.openhome;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by zhujie on 16/1/11.
 */
public class User implements HttpSessionBindingListener {

    private String name;
    private String data;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        this.data = name + " 来自数据库的数据...";
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}
