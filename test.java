import java.util.*;

class test{
	static int add(int a){
		a=a+233;
		return a;
	}
	public static void main(String[] args){
		static int a= 1;
		add(a);
		System.out.println(a);
	}
}
