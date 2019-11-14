class test{
	public static void main(String[] args){
		int[] a= new int[]{6,7,8};
		int[] b= new int[]{8,9,6};
		int[] temp = a;
		a=b;
		b= temp;
		
		for(int i=0; i<3; i++){
			System.out.println(temp[i]);
		}
		System.out.println();
	}
}