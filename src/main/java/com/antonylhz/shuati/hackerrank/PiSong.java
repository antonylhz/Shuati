package com.antonylhz.shuati.hackerrank;

import java.math.BigInteger;
import java.util.*;

public class PiSong {

	static int[] pi;
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        // decompose PI
        String piStr = "31415926535897932384626433833";
        pi = new int[piStr.length()];
        for(int i=0; i<piStr.length(); i++) pi[i] = Integer.parseInt(piStr.substring(i, i+1));
        
            System.out.println(
                isPiSong("Now I wish I could recollect pi Eureka cried the great inventor Christmas Pudding Christmas Pie Is the problems very center")?
                "It's a pi song.":
                "It's not a pi song."
            );
        
    }
    
    static boolean isPiSong(String song) {
        String[] strs = song.split(" ");
        for(int i=0; i<strs.length; i++) {
            if(strs[i].length()!=pi[i])
                return false;
        }
        return true;
    }
}
