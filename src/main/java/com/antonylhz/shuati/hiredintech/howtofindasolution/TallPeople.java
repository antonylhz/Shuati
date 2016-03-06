package com.antonylhz.shuati.hiredintech.howtofindasolution;

/**
 * Problem Statement
     A group of people stand before you arranged in rows and columns. Looking from above, they form an R by C rectangle of people. You will be given a String[] people containing the height of each person. Elements of people correspond to rows in the rectangle. Each element contains a space-delimited list of integers representing the heights of the people in that row. Your job is to return 2 specific heights in a int[]. The first is computed by finding the shortest person in each row, and then finding the tallest person among them (the "tallest-of-the-shortest"). The second is computed by finding the tallest person in each column, and then finding the shortest person among them (the "shortest-of-the-tallest").

     Definition

     Class:	TallPeople
     Method:	getPeople
     Parameters:	String[]
     Returns:	int[]
     Method signature:	int[] getPeople(String[] people)
     (be sure your method is public)


     Constraints
     -	people will contain between 2 and 50 elements inclusive.
     -	Each element of people will contain between 3 and 50 characters inclusive.
     -	Each element of people will be a single space-delimited list of positive integers such that:

     1) Each positive integer is between 1 and 1000 inclusive with no extra leading zeros.

     2) Each element contains the same number of integers.

     3) Each element contains at least 2 positive integers.

     4) Each element does not contain leading or trailing whitespace.

     Examples
     0)

     {"9 2 3",
     "4 8 7"}
     Returns: { 4,  7 }
     The heights 2 and 4 are the shortest from the rows, so 4 is the taller of the two. The heights 9, 8, and 7 are the tallest from the columns, so 7 is the shortest of the 3.
     1)

     {"1 2",
     "4 5",
     "3 6"}
     Returns: { 4,  4 }
     2)

     {"1 1",
     "1 1"}
     Returns: { 1,  1 }
 */

public class TallPeople {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 1000;

    private int[][] grid;
    private int height, width;

    public int[] getPeople(String[] people) {
        loadPeople(people);
        int[] res = new int[2];
        res[0] = tallestInRowShorts();
        res[1] = shortestInColumnTalls();
        return res;
    }

    private void loadPeople(String[] people) {
        height = people.length;
        width = (1 + people[0].length()) / 2;
        grid = new int[height][width];
        for (int i = 0; i < height; i++) {
            String[] tokens = people[i].split("\\s+");
            grid[i] = new int[width];
            for (int j = 0; j < width; j++) {
                grid[i][j] = Integer.parseInt(tokens[j]);
            }
        }
    }

    private int tallestInRowShorts() {
        int res = MIN_HEIGHT - 1;
        for (int i = 0; i < height; i++) {
            int shortest = MAX_HEIGHT + 1;
            for (int j = 0; j < width; j++) {
                shortest = Math.min(shortest, grid[i][j]);
            }
            res = Math.max(res, shortest);
        }
        return res;
    }

    private int shortestInColumnTalls() {
        int res = MAX_HEIGHT + 1;
        for (int j = 0; j < width; j++) {
            int tallest = MIN_HEIGHT - 1;
            for (int i = 0; i < height; i++) {
                tallest = Math.max(tallest, grid[i][j]);
            }
            res = Math.min(res, tallest);
        }
        return res;
    }

}
