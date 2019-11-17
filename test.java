class test{
	public static void main(String[] args){
		int[] a= new int[]{6,7,8};
		int[] b= new int[3];
		System.arraycopy(a,0,b,0,3);
		a[2]=100;
		System.out.println(b[2]);
	}
}