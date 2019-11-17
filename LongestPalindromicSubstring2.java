class LongestPalindromixSubstring2{
    int reverse(int i, int si, int ei){
        if(si==ei) return i;
        return ei-(i-si);
    }
    public String longestPalindrome(String s) {
        int max=0;
        String ans="";
        
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        String s_=sb.toString();
        
        for(int si=0; si<s.length(); si++){
            System.out.println("si="+si);
            for(int ei=si+max; ei<s.length(); ei++){
                if(s.substring(si,ei+1).equals(s_.substring(reverse(ei,0,s.length()-1),reverse(si,0,s.length()-1)+1))){
                    ans=s.substring(si,ei+1);
                    max=ans.length();
                }
            }
        }
        return ans;
            
    }
}