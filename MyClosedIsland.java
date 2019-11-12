import java.util.*;

class MyClosedIsland{
	int[][] map;
	int rows;
	int cols;
	arrayOrInteger[][] rOSMap;//Object can only be int[] or Integer. rOSMap=rootOrSize Map
	
	class arrayOrInteger{
		Integer size;
		int[] root;
		
		arrayOrInteger(int n, int r, int c){
			size = new Integer(n);
			root = new int[]{r,c};
		}
	}
	
	MyClosedIsland(int[][] input){
		map=input;
		rows=input.length;
		cols=input[0].length;
		rOSMap = new arrayOrInteger[rows][cols];
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(input[i][j]==1)
					rOSMap[i][j]= new arrayOrInteger(0,i,j);
				if(input[i][j]==0)
					rOSMap[i][j]= new arrayOrInteger(1,i,j);
			}
		}
	}
	
	int numIslands(){
		int ans=0;
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(j+1<cols)
					if(map[i][j]==0 && map[i][j+1]==0) unify(i,j,i,j+1);
				if(i+1<rows)
					if(map[i][j]==0 && map[i+1][j]==0) unify(i,j,i+1,j);
			}
		}
		for(int i=1; i<rows-1; i++){
			for(int j=1; j<cols-1; j++){
				if(rOSMap[i][j].size>=1) ans++;
			}
		}
		return ans;
	}
	
	
	boolean isEdge(int r, int c){
		return (r==0 || r== rows-1 || c==0 || c==cols-1);
	}
	
	int[] root(int r, int c){
		if(map[r][c]==1){
			System.out.println("Cannot call root on water");
			System.exit(0);
		}
		if(rOSMap[r][c].size>=1) return rOSMap[r][c].root;
		return rOSMap[r][c].root = root(rOSMap[r][c].root[0], rOSMap[r][c].root[1]);
	}
	
	void unify(int r1, int c1, int r2, int c2){
		//case1: (r1,c1) is not edge and (r2,c2) is edge
		
		if(!isEdge(r1,c1) && isEdge(r2,c2)){
			int temp1;
			temp1=r1;
			r1=r2;
			r2=temp1;
			int temp2;
			temp2=c1;
			c1=c2;
			c2=temp2;
		}
		int[] x = root(r1,c1);
		int[] y = root(r2,c2);
		
		if(x==y) return;
		
		rOSMap[x[0]][x[1]].size += rOSMap[y[0]][y[1]].size;
		rOSMap[y[0]][y[1]].size = 0;
		rOSMap[y[0]][y[1]].root = rOSMap[x[0]][x[1]].root;
				
	}
	
	void printROSMap(){
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				System.out.print(rOSMap[i][j].size);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	
	public static void main(String[] args){
		int[][] input = {{1,0,0,1,1,1,1},
						 {1,0,1,0,1,0,1},
						 {1,1,1,1,1,0,1},
						 {0,0,1,1,0,0,1},
						 {1,0,0,0,0,0,1},
						 {1,1,1,1,1,1,1}};
		MyClosedIsland a = new MyClosedIsland(input);
		System.out.println(a.numIslands());
	}
}
