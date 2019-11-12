/*
Given a 2D grid consisting of 0s (land) and 1s (water).  A closed island is a group of adjacent 0s 
totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.
*/

import java.util.*;
import java.io.*;

class closedIsland_{
	public int closedIsland(int[][] a) {
		int n = a.length, m = a[0].length;
		DJSet ds = new DJSet(n*m+1);
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				System.out.println();
				System.out.println("i=" + i + ", j=" + j);
				System.out.println("Upper[] now looks like:");
				ds.print();
				if(j+1 < m && a[i][j] + a[i][j+1] == 0){
					System.out.println("both pos and pos.right() are zeros, so union them");
					ds.union(i*m+j, i*m+j+1);
				}
				if(i+1 < n && a[i][j] + a[i+1][j] == 0){
					System.out.println("pos and pos.down are zeros, so union them");
					ds.union(i*m+j, (i+1)*m+j);
				}
				if(i == 0 || i == n-1 || j == 0 || j == m-1){
					System.out.println("position is on edge, so union current position and lastPos");
					ds.union(i*m+j, n*m);
				}
				
			}
		}
		int ret = 0;
		for(int i = 0;i < n*m;i++){
			System.out.println("Checking pos: " +i/m + "," + i%m);
			if(ds.upper[i] < 0 && !ds.equiv(i, n*m) && a[i/m][i%m] == 0){
				System.out.println("    pos: " + i/m + "," + i%m + " is an island");
				ret++;
			}
		}
		return ret;
	}
	
	public class DJSet {
		public int[] upper;

		public DJSet(int n) {
			upper = new int[n];
			Arrays.fill(upper, -1);
		}

		void print(){
			for(int i=0; i<5; i++){
				for(int j=0; j<6; j++){
					if(upper[i*6+j]<0 && upper[i*6+j]>-10)
						System.out.print(" " +upper[i*6+j]+" ");
				
					else if(upper[i*6+j]>=0)
					System.out.print("  " +upper[i*6+j]+" ");
				
					else if(upper[i*6+j]<=-10)
					System.out.print(upper[i*6+j]+" ");
				}
				System.out.println();
			}
			System.out.println("  " + upper[30]);
		}

		/*if rootArray.get(r,c)<0, then (r,c) is a root
		otherwise, (r,c) is not a root. (r,c) will store the position of the root it is connected to
		if rootArray.get(r,c) is negative, the magnitude indicates how many blocks this root contains
		*/
		public int root(int x) {
			System.out.println("Calling root(" + x + ")");
			if(upper[x]<0){
				System.out.println("upper["+x+"]<0, so return "+x);
				return x;
			}
			else{
				System.out.println("upper["+x+"]>=0, so return root(upper["+x+"])");
				upper[x] = root(upper[x]);
				return upper[x];
			}
		}

		public boolean equiv(int x, int y) {
			return root(x) == root(y);
		}

		/*if roots are the same, do nothing.
		otherwise, if the second argument is a deeper root then the first argument, swap arguments so that
			first argument is deeper root
		next, combine blocks and increase magnitude of deeper root accordingly
		change the root value of the second argument to the index of the first argument
		*/
		public boolean union(int x, int y) {
			System.out.println("Calling union on [" + x/6+","+x%6 + "] and [" + y/6+","+y%6+"]");
			x = root(x);
			y = root(y);
			if (x != y) {
				System.out.println("Since pos " + x + " not equal to pos " + y);
				if (upper[y] < upper[x]) {
					System.out.println("and upper[" +y+ "]<upper[" +x+ "], so swap the values of x and y");
					int d = x;
					x = y;
					y = d;
				}
				System.out.println("upper[" +x+ "]=upper[" +x+ "] + upper["+y+"]= " + (upper[x]+upper[y]));
				System.out.println("upper["+y+"]="+x);
				upper[x] += upper[y];
				upper[y] = x;
			}
			return x == y;
		}

		public int count() {
			int ct = 0;
			for (int u : upper)
				if (u < 0)
					ct++;
			return ct;
		}
	}

	public static void main(String[] args){
		try{
			File file = new File("output.txt");
			PrintStream p = new PrintStream(file);
			System.setOut(p);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		int[][] grid={{1,1,0,1,1,1},
					  {1,0,1,0,1,1},
					  {1,0,1,0,0,1},
					  {1,0,0,1,1,1},
					  {1,1,1,1,0,1}};
					  
		closedIsland_ c = new closedIsland_();
		System.out.println(c.closedIsland(grid));
	}
}