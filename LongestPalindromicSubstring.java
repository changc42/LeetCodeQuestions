class LongestPalindromicSubstring{
	public String longestPalindrome(String s) {
        int max=0;
        String ans="";
        boolean isPal;
        for(int i=0; i<s.length(); i++){
            if(s.length()==1){
                ans=s.substring(0);
                break;
            }
            for(int j=i+max; j<s.length(); j++){
                isPal=true;
                for(int k=0; k<(j-i+1)/2; k++){
                    if(s.charAt(i+k)!=s.charAt(j-k)){
                        isPal=false;
                        break;
                    }
                }
                if(isPal && j-i+1>max){
                    max=j-i;
                    ans=s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
	public static void main(String[] args){
		String s = "ababdbaba";
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		System.out.println(longestPalindrome(s));
	}
}