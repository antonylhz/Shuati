package com.antonylhz.shuati.hiredintech.howtofindasolution;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonylhz on 3/5/16.
 */
public class TallPeopleTest {

    private static final TallPeople solution = new TallPeople();

    @Test
    public void testGetPeople() throws Exception {
        List<String[]> people = new ArrayList<>();
        people.add(new String[] {
                "9 2 3",
                "4 8 7"
        });
        people.add(new String[] {
                "1 2",
                "4 5",
                "3 6"
        });
        people.add(new String[] {
                "1 1",
                "1 1"
        });

        List<int[]> result = new ArrayList<>();
        result.add(new int[] {
                4,  7
        });
        result.add(new int[] {
                4,  4
        });
        result.add(new int[] {
                1,  1
        });

        for(int i = 0; i < people.size(); i++) {
            Assert.assertArrayEquals("ERROR @ TEST CASE " + i,
                    result.get(i),
                    solution.getPeople(people.get(i)));
        }

    }
}