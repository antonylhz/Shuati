package com.antonylhz.shuati.hiredintech.howtofindasolution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Problem Statement
 The toy company "I Can't Believe It Works!" has hired you to help develop educational toys. The current project is a word toy that displays four letters at all times. Below each letter are two buttons that cause the letter above to change to the previous or next letter in alphabetical order. So, with one click of a button the letter 'c' can be changed to a 'b' or a 'd'. The alphabet is circular, so for example an 'a' can become a 'z' or a 'b' with one click.

 In order to test the toy, you would like to know if a word can be reached from some starting word, given one or more constraints. A constraint defines a set of forbidden words that can never be displayed by the toy. Each constraint is formatted like "X X X X", where each X is a string of lowercase letters. A word is defined by a constraint if the ith letter of the word is contained in the ith X of the contraint. For example, the constraint "lf a tc e" defines the words "late", "fate", "lace" and "face".

 You will be given a String start, a String finish, and a String[] forbid. Calculate and return the minimum number of button presses required for the toy to show the word finish if the toy was originally showing the word start. Remember, the toy must never show a forbidden word. If it is impossible for the toy to ever show the desired word, return -1.

 Definition

 Class:	SmartWordToy
 Method:	minPresses
 Parameters:	String, String, String[]
 Returns:	int
 Method signature:	int minPresses(String start, String finish, String[] forbid)
 (be sure your method is public)


 Constraints
 -	start and finish will contain exactly four characters.
 -	start and finish will contain only lowercase letters.
 -	forbid will contain between 0 and 50 elements, inclusive.
 -	Each element of forbid will contain between 1 and 50 characters.
 -	Each element of forbid will contain lowercase letters and exactly three spaces.
 -	Each element of forbid will not contain leading, trailing or double spaces.
 -	Each letter within a group of letters in each element of forbid will be distinct. Thus "aa a a a" is not allowed.
 -	start will not be a forbidden word.

 Examples
 0)

 "aaaa"
 "zzzz"
 {"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"}
 Returns: 8
 1)

 "aaaa"
 "bbbb"
 {}
 Returns: 4
 Simply change each letter one by one to the following letter in the alphabet.
 2)

 "aaaa"
 "mmnn"
 {}
 Returns: 50
 Just as in the previous example, we have no forbidden words. Simply apply the correct number of button presses for each letter and you're there.
 3)

 "aaaa"
 "zzzz"
 {"bz a a a", "a bz a a", "a a bz a", "a a a bz"}
 Returns: -1
 Here is an example where it is impossible to go to any word from "aaaa".
 4)

 "aaaa"
 "zzzz"
 {"cdefghijklmnopqrstuvwxyz a a a",
 "a cdefghijklmnopqrstuvwxyz a a",
 "a a cdefghijklmnopqrstuvwxyz a",
 "a a a cdefghijklmnopqrstuvwxyz"}
 Returns: 6
 5)

 "aaaa"
 "bbbb"
 {"b b b b"}
 Returns: -1
 6)

 "zzzz"
 "aaaa"
 {"abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"}
 Returns: -1
 This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.

 This problem was used for:
 Single Round Match 233 Round 1 - Division I, Level Two

 */

public class SmartWordToy {
    public static final int N = 4;
    private List<List<Set<Character>>> forbiddenWords;

    public SmartWordToy(String[] rawForbiddenWords) {
        this.forbiddenWords = parseForbiddenWords(rawForbiddenWords);
    }

    private List<List<Set<Character>>> parseForbiddenWords(String[] constrains) {
        List<List<Set<Character>>> res = new ArrayList<>();
        for (String str : constrains) {
            String[] tokens = str.split("\\s+");
            List<Set<Character>> cur = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                Set<Character> set = new HashSet<>();
                for (char c : tokens[i].toCharArray()) {
                    set.add(c);
                }
                cur.add(set);
            }
            res.add(cur);
        }
        return res;
    }

    private boolean isForbidden(String word) {
        if (word == null || word.length() != N) {
            return false;
        }
        for (List<Set<Character>> constraint : forbiddenWords) {
            if (isForbidden(word, constraint)) {
                return true;
            }
        }
        return false;
    }

    private boolean isForbidden(String word, List<Set<Character>> constraint) {
        for (int i = 0; i < N; i++) {
            if (!constraint.get(i).contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public int getMinClicks(String start, String end) {
        if (start == null || start.length() != N || end == null || end.length() != N) {
            return -1;
        }

        Deque<String> queue = new ArrayDeque<>();
        Set<String> used = new HashSet<>();
        int clicks = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.pollFirst();
                used.add(str);
                if (str.equals(end)) return clicks;
                for (int j = 0; j < N; j++){
                    char[] chars = str.toCharArray();
                    chars[j] = (char) ('a' + (chars[j] - 'a' + 1) % 26);
                    String updated = String.copyValueOf(chars);
                    if (!isForbidden(updated) && !used.contains(updated)) {
                        queue.add(updated);
                    }
                    chars[j] = (char) ('a' + (chars[j] - 'a' + 24) % 26);
                    updated = String.copyValueOf(chars);
                    if (!isForbidden(updated) && !used.contains(updated)) {
                        queue.add(updated);
                    }
                }
            }
            clicks++;
        }
        return -1;
    }

}
