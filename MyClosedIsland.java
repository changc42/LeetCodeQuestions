import java.util.*;

class MyClosedIsland{
	int[][] map;
	int rows;
	int cols;
	ArrayList<ArrayList<Object>> rOS;//Object can only be int[] or Integer. rOS=rootOrSize
	
	MyClosedIsland(int[][] input){
		map=input;
		rows=input.length;
		cols=input[0].length;
		
		for(int i=0; i<rows; i++){
			rOS.add(new ArrayList<Object>());
			for(int j=0; j<cols; j++){
				rOS.get(i).add(new Integer(1));
			}
		}
	}
	
	class ROS{
		
	}
	
	static Object numIslands(){
		int ans=0;
		
		return ans;
	}
	
	Integer getSize(int r, int c){
		if(rOS.get(r).get(c) instanceof Integer) return rOS.get(r).get(c);
		else return getSize(rOS.get(r).get(c)[0], rOS.get(r).get(c)[1]);
	}
	
	
	void unify(int r1, int c1, int r2, int c2){
		//if second position is on edge, swap values so edge position becomes root
		if(r2==0 || r2==rows-1 || c2==0 || c2==cols-1){
			int temp1;
			temp1=r1;
			r1=r2;
			r2=temp1;
			int temp2;
			temp2=c1;
			c1=c2;
			c2=temp2;
		}
		if(rOS.get(r1).get(c1) instanceof int[]){
			rOS.get(rOS.get(r1).get(c1)[0]).get(rOS.get(r1).get(c1)[1])
			rOS.get(r2).set(c2,new int[]{r1,c1});
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
