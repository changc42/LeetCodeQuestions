import java.util.*;

class GenerateParentheses{
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
		System.out.println("\nplaceParen called: i="+i);
		System.out.println("charArray: " + String.valueOf(charArray));
		if(i>=2*n){
			System.out.println("break early");
			return;
		}

		n--;
		charArray[i]='(';
		System.out.println("charArray updated: " + String.valueOf(charArray));
		for(int k=i+1; k<2*n; k++){
			System.out.println("k="+k);
			System.out.println("charArray right before placeParen: " + String.valueOf(charArray));
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

		System.out.println("char removed");
		charArray[i]=' ';
		n++;
		return;

	}
	public List<String> generateParentheses(int n) {
		char[] charArray = new char[2*n];
		for(int i=0; i<n+1; i++) placeParen(i, n, charArray);
		return ans;
	}

	public static void main(String[] args){
		GenerateParentheses a = new GenerateParentheses();
		System.out.println("Answer: "+a.generateParentheses(3));
	}

}
