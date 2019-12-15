import java.util.*;

class GenerateParenthesis{
	List<String> ans = new LinkedList<>();

	boolean isParenGood(char[] charArray){
		LinkedList<Character> stack = new LinkedList<>();
		for(char c: charArray){
			if(c=='(') stack.add('(');
			if(c==')'){
				if(stack.size()==0) return false;
				stack.removeFirst();
			}
		}
		if(stack.size()!=0) return false;
		return true;
	}

	void placeParen(int i, int n, char[] charArray){
		System.out.println("placeParen called: i="+i);
		if(i>=2*n) return;

		n--;
		charArray[i]='(';
		System.out.println("charArray updated: " + String.valueOf(charArray));
		for(int k=i+1; k<2*n; k++){
			System.out.println("k="+k);
			placeParen(k, n, charArray);
		}

		if(n==0){
			for(int j=0; j<2*n; j++){
				if(charArray[j]==' ') charArray[j]=')';
			}
			System.out.println(String.valueOf(charArray));
			if(isParenGood(charArray)){
				String potential = String.valueOf(charArray);
				ans.add(potential);
			}
		}

		charArray[i]=' ';
		n++;
		return;

	}
	public List<String> generateParenthesis(int n) {
		static char[] charArray = new char[2*n];
		for(int i=0; i<n+1; i++) placeParen(i, n, charArray);
		return ans;
	}

	public static void main(String[] args){
		GenerateParentheses a = new GenerateParentheses();
		System.out.println("Answer: "+a.generateParenthesis(3));
	}

}
