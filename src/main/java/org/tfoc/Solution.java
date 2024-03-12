package org.tfoc;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public static void main(String[] args) {

        Integer[][] matriz = {
                {1, 1, 0, 2},
                {1, 2, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 2}
        };

        System.out.println(search(matriz));

    }

    public static Integer search(
            Integer[][] grid) {

        Integer[][] aux = new Integer[grid.length][grid.length];

        int unrottenOranges = 0;
        int minutesPassed = 0;

        //saco el numero de naranjas que no se han podrido
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid.length; j++){

                if((i-1<0||grid[i-1][j]==0)
                        &&(j-1<0||grid[i][j-1]==0)
                        &&(i+1>= grid.length||grid[i+1][j]==0)
                        &&(j+1>= grid.length||grid[i][j+1]==0)){
                    return -1;
                }

                if(grid[i][j]==1){
                    unrottenOranges++;
                }
            }
        }

        while(unrottenOranges!=0) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {

                    if (grid[i][j] == 1) {
                        if ((j + 1 <= grid.length-1 && grid[i][j + 1] == 2) || (i + 1 <= grid.length-1 && grid[i+1][j] == 2)) {
                            aux[i][j] = 2;
                            unrottenOranges--;
                        } else {
                            aux[i][j] = 1;
                        }
                    } else {
                        aux[i][j] = 0;
                    }

                }
            }

            grid = aux;
            minutesPassed++;

        }

        return minutesPassed;
    }

}
