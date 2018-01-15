package com.santoni.recentlyusedlist;

import java.util.LinkedList;
import java.util.List;

public class RecentlyUsedList {
    private LinkedList<Object> recentItems = new LinkedList<>();
    private int size = -1;

    public RecentlyUsedList(int size) {
        this.size = size;
    }

    public RecentlyUsedList() {

    }

    public List<Object> getRecentItems() {
        return recentItems;
    }

    public void add(Object o) {
        if(o==null) throw new IllegalArgumentException("null values are forbidden");
        if(recentItems.contains(o)) {
            recentItems.remove(o);
        }
        recentItems.addFirst(o);
        if(size!= -1 && recentItems.size()==size+1){
            recentItems.remove(size);
        }
    }
}
