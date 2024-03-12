package org.tfoc;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public static void main(String[] args) {

        Integer[][] matriz = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(search(matriz));

    }

    public static Integer search(
            Integer[][] grid) {

        Integer[][] auxiliaryGrid = new Integer[grid.length][grid.length];

        int notRottenOranges = 0;
        int minutesPassed = 0;

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid.length; j++){

                //Checking if an orange is not rotten and inaccesible to rotten ones
                if((i-1<0||grid[i-1][j]==0)
                        && (j-1<0||grid[i][j-1]==0)
                        && (i+1>= grid.length||grid[i+1][j]==0)
                        && (j+1>= grid.length||grid[i][j+1]==0)
                        && grid[i][j]==1){

                    return -1;
                }

                //Counting the not rotten oranges
                if(grid[i][j]==1){
                    notRottenOranges++;
                }
            }
        }

        //We rot until there are no good oranges left
        while(notRottenOranges!=0) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {

                    //Checking if an orange is not rotten, and if its adjacent to a rotten one, then we rot it
                    if (grid[i][j] == 1) {
                        if ((j + 1 <= grid.length-1 && grid[i][j + 1] == 2)
                                || (i + 1 <= grid.length-1 && grid[i+1][j] == 2)
                                || (j - 1 >= 0 && grid[i][j - 1] == 2)
                                || (i - 1 >= 0 && grid[i - 1][j] == 2)) {
                            auxiliaryGrid[i][j] = 2;
                            notRottenOranges--;
                        }
                        //The rest should be equal
                        else {
                            auxiliaryGrid[i][j] = 1;
                        }
                    } else if(grid[i][j] == 2){
                        auxiliaryGrid[i][j] = 2;
                    } else {
                        auxiliaryGrid[i][j] = 0;
                    }

                }
            }

            //Each cicle is a minute, and the new grid is the auxiliary grid, while resetting this one
            grid = auxiliaryGrid;
            auxiliaryGrid = new Integer[grid.length][grid.length];
            minutesPassed++;

        }

        return minutesPassed;
    }

}
