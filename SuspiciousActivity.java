import java.util.*;

/*given an input (String[]) and a threshold number(int)
each element is a string of 3 numbers separated by spaces.
the first numbers are receiver and sender id.
the third nubmer is a transaction amount.
identify the id's of users that participated at least "threshold" number of transactions
a transaction where a user sends money to himself counts as one transaction, not two
*/

class SuspiciousActivity{
  static LinkedList<String> findSusAct(String[] logs, int threshold){
    Map<String, Integer> map = new HashMap<>();
    LinkedList<String> ans = new LinkedList<>();

    for(String log: logs){
      String[] split = log.split(" ");

      if(split[0].equals(split[1])) map.put(split[0], map.getOrDefault(split[0], 0)+1 );
      else{
        map.put(split[0], map.getOrDefault(split[0], 0)+1 );
        map.put(split[1], map.getOrDefault(split[1], 0)+1 );
      }
    }

    for(Map.Entry<String, Integer> entry: map.entrySet()){
      if(entry.getValue()>=threshold) ans.add(entry.getKey());
    }

    ans.sort((a,b)->{
      return a.compareTo(b);
    });
    
    return ans;
  }

  public static void main(String[] args){
    String [] logs= new String[]{"88 99 200", "88 99 200","99 32 100","12 12 15"};
    LinkedList<String> ans = findSusAct(logs, 2);
    System.out.println( Arrays.toString(ans.toArray()) );

  }
}