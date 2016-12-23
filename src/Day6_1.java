import java.util.Arrays;
import java.util.Vector;

public class Day6_1 {
	Day6_1(){
		String[] input = new FileReader().readLines("input/Day6_1_validation.txt"); //Should give answer 'easter'.
		String decoded = "";
		
	}
	
	private String errorCorrect(String[] input){
		String corrected = "";
		Vector<Letter> letters = new Vector<Letter>();
		
		//Create a vector of letters and their number of occurrences.
		for(int i = 0; i < input.length(); i++){
			char letter = input.charAt(i);
			if(!letters.isEmpty()){
				boolean found = false;
				for(int j = 0; j < letters.size() && !found; j++){
					if(letters.elementAt(j).letter == letter){
						found = true;
						letters.elementAt(j).occurrences++;
					}
				}
				if(!found){
					letters.addElement(new Letter(letter));
				}
			}
			else{
				letters.addElement(new Letter(letter));
			}
		}
		
		//Create the actual checksum.
		while(letters.size() > 0){
			//Get the highest number of letter occurrences.
			int highestOccurrence = 0;
			for(int i = 0; i < letters.size(); i++){
				if(letters.elementAt(i).occurrences > highestOccurrence){
					highestOccurrence = letters.elementAt(i).occurrences;
				}
			}
			
			//Fetch the letters that occurs the specified number of times.
			String part = "";
			for(int i = 0; i < letters.size(); i++){
				if(letters.elementAt(i).occurrences == highestOccurrence){
					part = part.concat(String.valueOf(letters.elementAt(i).letter));
					letters.remove(i);
					i--;
				}
			}
			
			//Sort the string and add it to the checksum.
			char[] charPart = part.toCharArray();
			Arrays.sort(charPart);
			checksum = checksum.concat(new String(charPart));
		}
		
		//Return at most 5 characters
		if(checksum.length() > 5){
			return checksum.substring(0, 5);
		}
		else{
			return checksum;
		}
	}

	public static void main(String[] args) {
		new Day6_1();
	}
}
