/*
given two sorted arrays of int, find the median of all the numbers
*/

class MedianTwoSortedArrays{
	int[] nums1, nums2;
	
	MedianTwoSortedArrays(int[] a, int[] b){
		nums1=a;
		nums2=b;
	}
	
	void rearrange(){
		if(nums1[nums1.length-1]>nums2[nums2.length-1]){
			int[] temp = nums1;
			nums1=nums2;
			nums2=temp;
		}
	}
	
	int median(){
		
	}
	
	public static void main(String[] args){
		MedianTwoSortedArrays a = new MedianTwoSortedArrays(nums1, nums2);
		System.out.println(a.median());
	}
}