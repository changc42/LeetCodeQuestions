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

class reconstructMatrix_{
	int upper;
	int lower;
	int[] colsum;
	int[][] ans;
	
	reconstructMatrix_(int u, int l, int[] c){
		upper=u;
		lower=l;
		colsum=c;
		ans = new int[2][colsum.length];
	}
	
	void reconstructMatrix(){
		if(!answerExists()){
			System.out.println("answer does not exist");
			System.exit(0);
		}
		
        for(int i=0; i<colsum.length; i++){
            int sum = colsum[i];
            while(sum>0){
                if(upper>=lower && upper>0){
                    ans[0][i]=1;
                    upper--;
                }else if(lower>upper && lower>0){
                    ans[1][i]=1;
                    lower--;
                }else{
					System.out.println("unconsidered exception");
					System.out.println("upper =" + " " + upper);
					System.out.println("lower = " + lower);
					System.out.println("sum= "+sum);
					System.exit(0);
				}
                sum--;
            }
        }
    }
	
	boolean answerExists(){
		int totalsum=0;
		for(int i=0; i<colsum.length; i++){
			totalsum+=colsum[i];
			if(colsum[i]>=3 || colsum[i]<0){
				System.out.println("colsum>=3 || colsum<0");
				return false;
			}
		}
		
		if(upper>colsum.length || lower>colsum.length){
			System.out.println("upper>colsum.length || lower>colsum.length");
			return false;
		}
		
		if(upper+lower!= totalsum){
			System.out.println("upper+lower!= totalsum");
			return false;
		}
		
		return true;
	}
	
	void print(){
		for(int i=0; i<2; i++){
			for(int j=0; j<colsum.length; j++){
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		int[] colsum = {1,1,1,0,1,0,1,2,2,2};
		reconstructMatrix_ a = new reconstructMatrix_(6,5,colsum);
		a.reconstructMatrix();
		a.print();
	}
}