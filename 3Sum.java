class Solution {
    int contains(int[] arr, int s, int e, int x){
        for(int i=s; i<=e; i++){
            if(arr[i]==x) return i;
        }
        return -1;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            if(i==0 || nums[i]!=nums[i-1]){
                
                for(int j=i+1; j<nums.length; j++){
                    if(j==i+1 || nums[j]!=nums[j-1]){
                        int cVal = -1*(nums[i]+nums[j]);
						if(cVal<j) continue;
                        int c=contains(nums,j+1,nums.length-1, cVal);
                        if(c>0){
                            List<Integer> sol = new ArrayList<>();
                            sol.add(nums[i]);
                            sol.add(nums[j]);
                            sol.add(nums[c]);
                            solutions.add(sol);
                        }
                    }
                }
            }
        }
        return solutions;
    }
}