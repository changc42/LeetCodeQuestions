import java.util.*;

class test{
	public static void main(String[] args){
		String i = "huupp";
		String j=i;
		i += "opoway";
		System.out.println("i="+i+" j=" +j);
		
		ArrayList<Integer> a = new ArrayList<>();
		a.add(100);
		ArrayList<Integer> b = a;
		a.add(4);
		System.out.println(a + "\n" + b);
		
		String s= "hello";
		System.out.println(s);
	}

}