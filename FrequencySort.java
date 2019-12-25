import java.util.*;

class FrequencySort{

	static String frequencySort(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
			map.put(c, map.getOrDefault(c,0)+1);
        }


		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new foo<Map.Entry<Character, Integer>>(){
			public int compare(Map.Entry<Character,Integer> e1, Map.Entry<Character,Integer> e2){
	            return e2.getValue()-e1.getValue();
	        }
		});

		for(Map.Entry<Character, Integer> e: map.entrySet()) maxHeap.add(e);

		StringBuilder sb = new StringBuilder();

		while(!maxHeap.isEmpty()){
			Map.Entry<Character, Integer> e = maxHeap.remove();
			for(int i=0; i<e.getValue(); i++) sb.append(e.getKey());
		}

        return sb.toString();
	}

	public static void main(String[] args){
		System.out.println(frequencySort("fsasfafafssfafijijijijijijijijffdxhhfhdf"));
	}
}
