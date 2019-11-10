/*
Consider a binary matrix(matrix only holds 0s and 1s) with 2 rows and n columns

Given an int upper which is the sum of the values in the top row,
and an int lower which is the sum of the values in the bottom row,
and an int[] colsum which stores the sum of the values in column "i" at index "i",
return a 2-dimensional array that satisfies the above conditions.

Example: upper=5, lower=5, colsum={2,1,2,0,1,0,1,2,0,1}
Returned array:{{1,1,1,0,0,0,1,1,0,0},
				{1,0,1,0,1,0,0,1,0,1}}

Note: there may be multiple answers
*/

import java.util.*;

class reconstructMatrix{
	public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[][] arr = new int[2][colsum.length];
        for(int i=0; i<colsum.length; i++){
            int sum = colsum[i];
            while(sum>0){
                if(upper>=lower && upper>0){
                    arr[0][i]=1;
                    upper--;
                }else if(lower>upper && lower>0){
                    arr[1][i]=1;
                    lower--;
                }
                sum--;
            }
        }
        List<List<Integer>> arrList= new ArrayList<>();
        for(int i=0; i<2; i++){
			arrList.add(new ArrayList<Integer>());
            for(int j=0; j<colsum.length; j++){
                arrList.get(i).add(new Integer(arr[i][j]));
            }
        }
        return arrList;
    }
	public static void main(String[] args){
		int[] colsum = {2,1,2,0,1,0,1,2,0,1};
		System.out.println(reconstructMatrix(5,5,colsum));
	}
}