package cc.openhome.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujie on 16/1/21.
 */
public class BookmarService {

    public List<Bookmark> getBookmarks() {
        List<Bookmark> bookmarks = new ArrayList<>();
        bookmarks.add(new Bookmark("www.a.com", "TitleA", "CategoryA"));
        bookmarks.add(new Bookmark("www.b.com", "TitleB", "CategoryB"));
        bookmarks.add(new Bookmark("www.c.com", "TitleC", "CategoryC"));
        bookmarks.add(new Bookmark("www.d.com", "TitleD", "CategoryD"));
        return bookmarks;
    }
}
