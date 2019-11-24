class minTimeVisitPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x=0;
        int y=0;
        int time=0;
        for(int i=0; i<points.length; i++){
            int a=points[i][0];
            int b=points[i][1];
			System.out.println("a=" + points[i][0]);
			System.out.println("b=" +points[i][1]);
            while(a!=x || b!=x){
                if(a<x) x--;
                if(a>x) x++;
                if(b<y) y--;
                if(b>y) y++;
                
				System.out.println("x=" +x);
				System.out.println("y=" +y);
                time++;
				System.out.println("time=" + time+ "\n");
            }
        }
        return time;
    }
	public static void main(String[] args){
		minTimeVisitPoints a = new minTimeVisitPoints();
		int[][] arr= new int[][]{{1,1},{3,4},{-1,0}};
		System.out.println(a.minTimeToVisitAllPoints(arr));
	}
}

