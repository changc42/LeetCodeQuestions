/*
Given a list of words, list of  single letters (might be repeating), and score of every character.

Return the maximum score of any valid set of words formed by using the given 
letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once.
Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
*/

class MaxScoreFromLetters{
	LinkedList<String> words;
	LinkedList<Character> letters;
	int[] scores;
	LinkedList<String> ans;
	LinkedList<String> potential;
	int max;
	
	MaxScoreFromLetters(String[] w, char[] l, int[] s){
		for(String str: w) words.add(str); //add() means add to end of list
		for(char c: l) letters.add(c);
		scores=s;
		max=0;
		potential = new LinkedList<>();
		ans = new LinkedList<>();
	}
	
	void findSolutions(){
		if(words.size()<1){
			System.out.println("Size of words list cannot be less than 1");
			System.exit(0);
		}
		
		for(String w: words){
			make(words.get(0);
				
			if(words.size()>1){
				String temp = words.removeFirst();
				findSolutions();
				words.addFirst(temp);
			}
			if(words.size()==1){
				int score=0;
				for(String str: potential){
					score += getScore(str);
				}
				if(score>max){
					ans.clear();
					for(String str: potential){
						ans.add(str);
					}
				}
			}
			
		}
	}
	
	void make(String str){//attempts to make string. if made, return true.
		LinkedList<Character> temp = new LinkedList<>();
		for(Character c:letters){
			temp.add(c);
		}
		
		int count=0;
		for(int i=0; i<str.length(); i++){
			if(temp.remove(str.charAt(i))) count++;
		}
		if(count==str.length()){
			letters=temp;
			potential.add(str);
		}
	}
	
	int getScore(String str){
		int ans=0;
		for(int i=0; i<str.length(); i++){
			ans += scores[int()str.charAt(i)-97];
		}
	}
	
	public static void main(String[] args){
		String[] words = {"dog", "cat", "dad", "good"};
		char[] letters ={'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
		int[] scores ={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
		
		MaxScoreFromLetters a = new MaxScoreFromLetters(words, letters, scores);
	}
}