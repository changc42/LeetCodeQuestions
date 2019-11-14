/*
Given a list of words, list of  single letters (might be repeating), and score of every character.

Return the maximum score of any valid set of words formed by using the given 
letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once.
Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
*/
import java.util.*;

class MaxScoreFromLetters{
	LinkedList<String> words;
	LinkedList<Character> letters;
	int[] scores;
	LinkedList<String> ans;
	LinkedList<String> potential;
	int max;
	
	MaxScoreFromLetters(String[] w, char[] l, int[] s){
		words = new LinkedList<>();
		potential = new LinkedList<>();
		ans = new LinkedList<>();
		letters = new LinkedList<>();
		scores=s;
		max=0;
		
		for(String str: w) words.add(str); //add() means add to end of list
		for(char c: l) letters.add(c);
		
	}
	
	void findSolutions(){
		if(words.size()<1){
			System.out.println("Size of words list cannot be less than 1");
			System.exit(0);
		}
		
		boolean b = addWord(words.get(0));
				
		if(words.size()>1){
			String temp = words.removeFirst();
			findSolutions();
			words.addFirst(temp);
		}
		if(words.size()==1){
			if(getScore(potential)>max){
				max = getScore(potential);
				ans.clear();
				for(String str: potential){
					ans.add(str);
				}
			}
		}
		if(b){
			String str = potential.removeLast();
			for(int i=0; i<str.length(); i++){
				letters.add(str.charAt(i));
			}
		}
			
		
	}
	
	boolean canAdd(String str){
		LinkedList<Character> temp = new LinkedList<>();
		for(Character c: letters){
			temp.add(c);
		}
		
		int count=0;
		for(int i=0; i<str.length(); i++){
			if(temp.remove((Character)str.charAt(i))) count++;
		}
		return count==str.length();
	}
	
	boolean addWord(String str){//attempts to add string. if added, return true.
		LinkedList<Character> temp = new LinkedList<>();
		for(Character c: letters){
			temp.add(c);
		}
		
		int count=0;
		for(int i=0; i<str.length(); i++){
			if(temp.remove((Character)str.charAt(i))) count++;
		}
		if(count==str.length()){
			letters=temp;
			potential.add(str);
			return true;
		}
		return false;
	}
	
	int getScore(String str){
		int ans=0;
		for(int i=0; i<str.length(); i++){
			ans += scores[(int)str.charAt(i)-97];
		}
		return ans;
	}
	
	int getScore(LinkedList<String> list){
		int score=0;
		for(String str: list){
				score += getScore(str);
			}
		return score;
	}
	
	public static void main(String[] args){
		String[] words = {"leetcode"};
		char[] letters ={'l','e','t','c','o','d'};
		int[] scores ={0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};
		
		MaxScoreFromLetters a = new MaxScoreFromLetters(words, letters, scores);
		for(String w: words){
			a.findSolutions();
			a.words.removeFirst();
		}
		System.out.println(a.ans.toString());
		System.out.println("Score is: " + a.getScore(a.ans));
	}
}