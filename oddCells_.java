/*
given an "indices" array of [r,c], and a n-by-m matrix initialized to zero,
for each element in "indices", increment the values in the specified row and column by one.
return the number of odd cells

Example: indices={{0,1},{1,1}}, n=2, m=3
	{{0,0,0},		{{1,2,1},		{{1,3,1},
	 {0,0,0}} --> 	 {0,1,0}} --> 	 {1,3,1}}
	 
	 there are 6 odd cells, so return 6.
*/

class oddCells_{
	static public int oddCells(int n, int m, int[][] indices) {
        int ans=0;
        int[][] arr = new int[n][m];
        for(int[] i:indices){
            int row = i[0];
            for(int j=0; j<m; j++){
                arr[row][j]++;
            }
            int col = i[1];
            for(int j=0; j<n; j++){
                arr[j][col]++;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]%2!=0) ans++;
            }
			System.out.println();
        }
		
        return ans;
    }
	public static void main(String[] args){
		int[][] indices = {{0,1},{1,1}};
		System.out.println(oddCells(2,3, indices));
	}
}