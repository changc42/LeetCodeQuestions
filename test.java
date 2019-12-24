import java.util.*;

class test{
	public static void main(String[] args){
		Hashtable<String, Integer> a = new Hashtable<>();
		String s = "hello";
		a.put(s,2);
		a.put(s,3);
		System.out.println(a.entrySet());
	}
}
