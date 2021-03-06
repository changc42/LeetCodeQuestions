/*
given two sorted arrays of int, find the median of all the numbers
*/



class MedianTwoSortedArrays{
	
	/**
	*@field a,b : arrays 1 and 2
	*@field p1,p2 : index of first element in second half (p stands for partition)
	*@field sInd,eInd : startIndex, endIndex
	*@field s1, s2: size of a and b
	*/
	int[] a, b;
	int p1, p2;
	int sInd, eInd;
	int s1, s2;
	
	/**
	 *@description : swaps arrays if m is bigger than n. Necessary because only the partition in 
	 *	the smaller array is directly changed
	 *
	 *@description : if a set is odd, the set will be partitioned such that the right side 
	 *	contains one extra element
	 *
	 *@description : formula assigned to p2 places partition2 such that the sum of the first sections of
	 *	a and b and the sum of the second sections of a and b are equal OR differ by 1.
	 */
	MedianTwoSortedArrays(int[] m, int[] n){
		if(m[m.length-1]>n[n.length-1]){
			int[] temp = m;
			m=n;
			n=temp;
		}
		a=m;
		b=n;
		s1=m.length;
		s2=n.length;
		
		sInd=0;
		eInd=m.length;
	}
	
	
	double median(){
		int x, y;
		while(true){
		
		/**
		 *@case p1==0: there are no elements in the first section of `a`
		 *@case p1==s1 : there are no elements in the second section of `a`
		 */
		
			p1 = (sInd+eInd)/2;
			p2 = (s1+s2)/2-p1;
			
			if(p1>0 && a[p1-1]>b[p2]){
				eInd = p1-1;
			}
			else if(p1<s1 && b[p2-1]>a[p1]){
				sInd = p1+1;
			}
			else{
				if(p1==0) x=b[p2-1];
				else if(p2==0) x=a[p1-1];
				else x=Math.max(a[p1-1],b[p2-1]);
				
				if(p2==s2) y=a[p1];
				else if(p1==s1) y=b[p2];
				else y=Math.min(a[p1],b[p2]);
				if((s1+s2)%2==1) return y;
				
				return (double)(x+y)/2;
			}
		}
		
	}
	
	public static void main(String[] args){
		int[] a = new int[]{10};
		int[] b = new int[]{20,30,40};
		MedianTwoSortedArrays obj = new MedianTwoSortedArrays(a, b);
		System.out.println(obj.median());
	}
}