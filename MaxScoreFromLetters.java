/*
Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given 
letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once.
Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
*/

class MaxScoreFromLetters{
	LinkedList<String> words;
	LinkedList<char> letters;
	int[] score;
	LinkedList<String> ans;
	
	MaxScoreFromLetters(String[] w, LinkedList<char> l, int[] s){
		words=w;
		letters=l;
		score=s;
	}
	
	private class Word{
		String str;
		int score;
		
		Word(String s){
			str = s;
			for(int i=0; i<str; i++){
				
			}
		}
	}
}