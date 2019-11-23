class Solution {
    int binarySearch(int[] arr, int s, int e, int x){
        if(s==e){
			if(nums[s]==x) return s;
			else return -1;
		}
		int i=(s+e)/2+1;
		
		if(nums[i]==x) return i;
		else if(nums[i]<x) binarySearch(arr,i,e,x);
		else if(nums[i]>x)binarySearch(arr,s,i,x);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++){
        if(i!=0 && nums[i]==nums[i-1]) continue;
                
			for(int j=i+1; j<nums.length-1; j++){
			if(j!=i+1 && nums[j]==nums[j-1]) continue;
				
				int cVal = -1*(nums[i]+nums[j]);
				if(cVal<j) break;
				int c=binarySearch(nums,j+1,nums.length-1, cVal);
				if(c>0) solutions.add(Arrays.asList(nums[i], nums[j], nums[c]);
			
			}
            
        }
        return solutions;
    }
}