import java.util.*;

class test{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2;j++){
                int SI = j+1;
                int EI = nums.length-1;
                while(SI<EI){
					System.out.println("SI="+SI+ " EI=" +EI);
                    if(nums[i]+nums[j]+nums[SI]+nums[EI]<target) SI++;
                    else if(nums[i]+nums[j]+nums[SI]+nums[EI]>target) EI--;
                    else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[SI]);
                        temp.add(nums[EI]);
                        ans.add(temp);
						SI++;
                    }
                }
            }
        }
        
        return ans;
    }
	public static void main(String[] args){
		int[] a=new int[]{-2,-1,1,2,-3,3,10};
		test b = new test();
		System.out.println(b.fourSum(a,0));
	}
}