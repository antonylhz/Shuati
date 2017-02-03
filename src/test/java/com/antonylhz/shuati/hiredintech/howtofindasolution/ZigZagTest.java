package com.antonylhz.shuati.hiredintech.howtofindasolution;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagTest {

    @Test
    public void findLongestAllZigZag() throws Exception {
        int[] nums = new int[] {
            1,2,1,2,1,2
        };
        assertEquals(6, ZigZag.findLongest(nums));
    }

    @Test
    public void findLongestMostlyUp() throws Exception {
        int[] nums = new int[] {
                1,2,3,4,2
        };
        assertEquals(3, ZigZag.findLongest(nums));
    }

}