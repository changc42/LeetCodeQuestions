import java.util.*;

class CombinationSum {
    int upperBoundIndex;
    List<List<Integer>> answer;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        upperBoundIndex = candidates.length-1;
        answer = new ArrayList<List<Integer>>();
        
        Stack<Integer> solution = new Stack<Integer>();
        while(true){
            while(sum(solution)<target) solution.push(candidates[upperBoundIndex]);
            
            if(sum(solution)==target){
                ArrayList<Integer> toBeAdded = new ArrayList<Integer>(solution);
                answer.add(toBeAdded);
            }
            
            solution.pop();
            if(upperBoundIndex==0){
                if(solution.empty()) return answer;
                else{
                    while(Arrays.binarySearch(candidates,solution.get(solution.size()-1))==0){
                        solution.pop();
                        if(solution.empty()) return answer;
                    }
                    upperBoundIndex = Arrays.binarySearch(candidates,solution.pop()) -1;
                }
            }else upperBoundIndex--;
        }
    }
    
    int sum(Stack<Integer> stack){
        int sum=0;
        for(Integer i: stack) sum+=i;
        return sum;
    }

    public static void main(String[] args){
        CombinationSum foo = new CombinationSum();
        int[] candidates = {2,3,5,7};
        List<List<Integer>> answer = foo.combinationSum(candidates, 7);
        for(List<Integer> solution: answer){
            System.out.println(solution.toString());
        }
    }
}