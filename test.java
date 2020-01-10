import java.util.*;
/*
class test{
	static List<String> toCorrectList(String[] arr){
        List<String> list = new LinkedList<>(Arrays.asList(arr));
        
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i)=="+");
        }
        
        return list;
    }
	public static void main(String[] args){
		String[] arr = new String[]{"1","3","+","4"};
		toCorrectList(arr);
	}
}
*/
class test{
	public static void main(String[] args){
		String s = "3+2";
		String s2= new String("3+2");
		System.out.println(s.equals(s2));
	}
}