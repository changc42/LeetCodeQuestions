import java.util.*;

class MyClosedIsland{
	int[][] map;
	int rows;
	int cols;
	Object[][] rOSMap;//Object can only be int[] or Integer. rOSMap=rootOrSize Map
	
	MyClosedIsland(int[][] input){
		map=input;
		rows=input.length;
		cols=input[0].length;
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(input[i][j]==1)
					rOSMap[i][j]=new Integer(0);
				if(input[i][j]==0)
					rOSMap[i][j]=new Integer(1);
			}
		}
	}
	
	static Object numIslands(){
		int ans=0;
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(map[i][j]==0 && map[i][j+1]==0 && j+1<cols) unify(i,j,i,j+1);
				if(map[i][j]==0 && map[i+1][j]==0 && i+1<rows) unify(i,j,i+1,j);
			}
		}
		for(int i=1; i<rows-1; i++){
			for(int j=1; j<cols-1; j++){
				if(rOSMap[i][j] instanceof Integer){
					if(rOSMap[i][j]>=1)
						ans++;
				}
			}
		}
		return ans;
	}
	
	
	boolean isEdge(int r, int c){
		return (r==0 || r== rows-1 || c==0 || c==cols-1)
	}
	
	void unify(int r1, int c1, int r2, int c2){
		//case1: (r1,c1) is not edge and (r2,c2) is edge
		if(!isEdge(r1,c1) && isEdge(r2,c2)){
			int temp1;
			temp1=r1;
			r1=r2;
			r2=temp1;
			int temp2;
			temp2=r2;
			r2=c2;
			c2=temp2;
		}
		
		Integer y = rOSMap[rOSMap[r2][c2][0]][rOSMap[r2][c2][1]];
		//case2: x is root and y is root
		if(rOSMap[r1][c1] instanceof Integer && rOSMap[r2][c2] instanceof Integer){
			rOSMap[r1][c1] += rOSMap[r2][c2];
			rOSMap[r2][c2] = new int[][]{r1,c1};
		}
		//case3: x is descendant and y is root
		if(rOSMap[r1][c1] instanceof int[][] && rOSMap[r2][c2] instanceof Integer){
			rOSMap[rOSMap[r1][c1][0]][rOSMap[r1][c1][1]] += rOSMap[r2][c2];
			rOSMap[r2][c2] = new int[][]{rOSMap[r1][c1][0], rOSMap[r1][c1][1]};
		}
		//case4:x is descendant and y is descendant
		if(rOSMap[r1][c1] instanceof int[][] && rOSMap[r2][c2] instanceof int[][]){
			rOSMap[rOSMap[r1][c1][0]][rOSMap[r1][c1][1]] += rOSMap[rOSMap[r2][c2][0]][rOSMap[r2][c2][1]]
			rOSMap[rOSMap[r2][c2][0]][rOSMap[r2][c2][1]] = new int[][]{rOSMap[r1][c1][0], rOSMap[r1][c1][1]};
		}
		//case 5: x is root and y is descendant
		if(rOSMap[r1][c1] instanceof Integer && rOSMap[r2][c2] instanceof int[][]){
			rOSMap[r1][c1] += rOSMap[rOSMap[r2][c2][0]][rOSMap[r2][c2][1]];
			rOSMap[rOSMap[r2][c2][0]][rOSMap[r2][c2][1]] = new int[][]{r1,c1};
		}
				
	}
	
	
	
	
	public static void main(String[] args){
		int[][] input = {{1,1,0,1,1,1},
						 {1,0,1,0,1,1},
						 {1,0,1,0,0,1},
						 {1,0,0,1,1,1},
						 {1,1,1,1,0,1}};
		MyClosedIsland a = new MyClosedIsland(input);
	}
}
