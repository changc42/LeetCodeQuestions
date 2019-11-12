import java.util.*;

class MyClosedIsland{
	int[][] map;
	int rows;
	int cols;
	ArrayList<ArrayList<Object>> rootOrSize;//Object can only be int[] or Integer
	
	MyClosedIsland(int[][] input){
		map=input;
		rows=input.length;
		cols=input[0].length;
		
		for(int i=0; i<rows; i++){
			rootOrSize.add(new ArrayList<Object>());
			for(int j=0; j<cols; j++){
				rootOrSize.get(i).add(new Integer(1));
			}
		}
	}
	
	static Object numIslands(){
		Integer ans=new Integer(0);
		
		return ans;
	}
	/*
	Object getRootOrSize(int r, int c){
		if(rootOrSize.get(r).get(c) instanceof Integer) return rootOrSize.get(r).get(c);
		else return 
	}
	*/
	
	
	
	public static void main(String[] args){
		int[][] input = {{1,1,0,1,1,1},
						 {1,0,1,0,1,1},
						 {1,0,1,0,0,1},
						 {1,0,0,1,1,1},
						 {1,1,1,1,0,1}};
		MyClosedIsland a = new MyClosedIsland(input);
	}
}
