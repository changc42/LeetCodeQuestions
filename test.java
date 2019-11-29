import java.util.concurrent.CopyOnWriteArrayList;

class test{
	public static void main(String[] args){
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		for(int i=0; i<10; i++){
			list.add(String.valueOf(i));
		}
		
		for(String s: list){
			list.add(s+"!!");
			list.remove("3");
		}
		
		System.out.println(list);
	}
}