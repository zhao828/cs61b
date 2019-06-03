public class Palindrome{
	public Deque<Character> wordToDeque(String word){
		Deque <Character> d = new LinkedListDeque<Character>();
		for (int i =0;i<word.length();i++){
			d.addLast(word.charAt(i));

		}


		return d;
	}

	public boolean isPalindrome(String word){
		Deque <Character> d = wordToDeque(word);
		for (int i =0;i<(int)d.size()/2;i++){
			if(d.removeLast()!=d.removeFirst()){
				return false;
			}
		}
		return true;
	}

	public boolean isPalindrome(String word, CharacterComparator cc){
		Deque <Character> d = wordToDeque(word);
		for (int i =0;i<(int)d.size()/2;i++){
			if(!cc.equalChars(d.removeFirst(),d.removeLast())){
				return false;
			}
		}
		return true;
	}

}