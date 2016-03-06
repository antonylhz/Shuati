package com.antonylhz.shuati.hiredintech.howtofindasolution;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by antonylhz on 3/5/16.
 */
public class BusinessTasksTest {

    private static final BusinessTasks solution = new BusinessTasks();

    @Test
    public void testGetTask() throws Exception {
        String[][] list = new String[][] {
                {"a", "b", "c", "d"},
                {"a","b","c","d","e"},
                {"alpha","beta","gamma","delta","epsilon"},
                {"a","b"},
                {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t", "u","v","w","x","y","z"},
                {"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp", "olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu", "qgcxjbfx","my","mlhy","bt","bo","q"}

        };
        int[] n = new int[] {
                2,
                3,
                1,
                1000,
                17,
                9000000
        };
        String[] result = new String[] {
                "a",
                "d",
                "epsilon",
                "a",
                "n",
                "fxjqzznvg"
        };
        for(int i=0; i<list.length; i++)
            Assert.assertEquals( "ERROR @ Test Case " + i, result[i], solution.getTask(list[i], n[i]));
    }
}