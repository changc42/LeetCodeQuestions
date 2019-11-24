class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[2];
        int difference=Math.abs(target-closestSum);
        
        
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            if(nums[i]>=0 && nums[i]>target){
                int sum=nums[i]+nums[i+1]+nums[i+2];
                int diff = Math.abs(target-sum);
                if(diff<difference){
                    difference=diff;
                    closestSum=sum;
                }
            }
            for(int j=i+1; j<nums.length-1; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                if(nums[i]+nums[j]>=0 && nums[i]+nums[j]>target){
                    int sum=nums[i]+nums[j]+nums[j+1];
                    int diff = Math.abs(target-sum);
                    if(diff<difference){
                        difference=diff;
                        closestSum=sum;
                    }
                }
                
                for(int k=j+1; k<nums.length; k++){
                    if(k>j+1 && nums[k]==nums[k-1]) continue;
                    int sum=nums[i]+nums[j]+nums[k];
                    int diff = Math.abs(target-sum);
                    if(diff<difference){
                        difference=diff;
                        closestSum=sum;
                    }
                    if(sum>=0 && sum>target) break;
                }
            }
        }
        
        return closestSum;
    }
}