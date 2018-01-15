package com.santoni.recentlyusedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecentlyUsedListTest {
    RecentlyUsedList recentlyUsedList;

    @Before
    public void initList(){
        recentlyUsedList = new RecentlyUsedList();
    }

    @Test
    public void listIsInitiallyEmpty(){
        assertEquals(0,recentlyUsedList.getRecentItems().size());
    }

    @Test
    public void listContainsLatestFirst(){
        recentlyUsedList.add("1");
        recentlyUsedList.add("2");
        assertEquals("2",recentlyUsedList.getRecentItems().get(0));
    }

    @Test
    public void listContainsOldestLast(){
        recentlyUsedList.add("1");
        recentlyUsedList.add("2");
        assertEquals("1",recentlyUsedList.getRecentItems().get(1));
    }

    @Test
    public void listContainsNoDuplicates(){
        recentlyUsedList.add("1");
        recentlyUsedList.add("2");
        recentlyUsedList.add("1");
        assertEquals(2,recentlyUsedList.getRecentItems().size());
        assertEquals("1",recentlyUsedList.getRecentItems().get(0));
        assertEquals("2",recentlyUsedList.getRecentItems().get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectNulls(){
        recentlyUsedList.add(null);
    }

    @Test
    public void listHasBoundedSize(){
        recentlyUsedList = new RecentlyUsedList(2);

        recentlyUsedList.add("1");
        recentlyUsedList.add("2");
        recentlyUsedList.add("3");
        assertEquals(2,recentlyUsedList.getRecentItems().size());
        assertEquals("3",recentlyUsedList.getRecentItems().get(0));
        assertEquals("2",recentlyUsedList.getRecentItems().get(1));
    }


}
