package com.antonylhz.shuati.hiredintech.howtofindasolution;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmartWordToyTest {

    @Test
    public void test0() {
        String start = "aaaa";
        String end = "zzzz";
        String[] forbidden = new String[] {"a a a a z"};
        SmartWordToy smartWordToy = new SmartWordToy(forbidden);
        assertEquals(4, smartWordToy.getMinClicks(start, end));
    }

    @Test
    public void test1() {
        String start = "aaaa";
        String end = "zzzz";
        String[] forbidden = new String[] {
                "a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"
        };
        SmartWordToy smartWordToy = new SmartWordToy(forbidden);
        assertEquals(8, smartWordToy.getMinClicks(start, end));
    }

    @Test
    public void test2() {
        String start = "aaaa";
        String end = "bbbb";
        String[] forbidden = new String[] {};
        SmartWordToy smartWordToy = new SmartWordToy(forbidden);
        assertEquals(4, smartWordToy.getMinClicks(start, end));
    }

    @Test
    public void test3() {
        String start = "aaaa";
        String end = "zzzz";
        String[] forbidden = new String[] {"bz a a a", "a bz a a", "a a bz a", "a a a bz"};
        SmartWordToy smartWordToy = new SmartWordToy(forbidden);
        assertEquals(-1, smartWordToy.getMinClicks(start, end));
    }

    @Test
    public void test4() {
        String start = "aaaa";
        String end = "zzzz";
        String[] forbidden = new String[] { "cdefghijklmnopqrstuvwxyz a a a",
                                            "a cdefghijklmnopqrstuvwxyz a a",
                                            "a a cdefghijklmnopqrstuvwxyz a",
                                            "a a a cdefghijklmnopqrstuvwxyz"};
        SmartWordToy smartWordToy = new SmartWordToy(forbidden);
        assertEquals(6, smartWordToy.getMinClicks(start, end));
    }

//    @Test
//    public void test5() {
//        String start = "zzzz";
//        String end = "aaaa";
//        String[] forbidden = new String[] {
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
//                "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"};
//        SmartWordToy smartWordToy = new SmartWordToy(forbidden);
//        assertEquals(-1, smartWordToy.getMinClicks(start, end));
//    }
}