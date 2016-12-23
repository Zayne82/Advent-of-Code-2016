import java.util.Vector;

public class Day6_1 {
	Day6_1(){
		//String[] input = new FileReader().readLines("input/Day6_1_validation.txt"); //Should give answer 'easter'.
		String[] input = new FileReader().readLines("input/Day6_1_input.txt");
		
		char[] corrected = new char[input[0].length()];
		for(int i = 0; i < corrected.length; i++){
			char[] column = new char[input.length];
			for(int j = 0; j < input.length; j++){
				//System.out.println("Getting character: " + input[j].charAt(i));
				column[j] = input[j].charAt(i);
			}
			corrected[i] = getMostCommonLetter(column);
		}
		System.out.println("Error corrected message: " + new String(corrected));
		
	}
	
	private char getMostCommonLetter(char[] input){
		Vector<Letter> letters = new Vector<Letter>();
		
		//Create a vector of letters and their number of occurrences.
		for(int i = 0; i < input.length; i++){
			char letter = input[i];
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
		
		
		//Find out the maximum number of times a letter occurs.
		int highestOccurrence = 0;
		for(int i = 0; i < letters.size(); i++){
			if(letters.elementAt(i).occurrences > highestOccurrence){
				highestOccurrence = letters.elementAt(i).occurrences;
			}
		}
		
		//Return the most common letter.
		for(int i = 0; i < letters.size(); i++){
			if(letters.elementAt(i).occurrences == highestOccurrence){
				return letters.elementAt(i).letter;
			}
		}
		
		//This should never be reached.
		System.out.println("Something went wrong, default value returned from function.");
		return '0';
	}

	public static void main(String[] args) {
		new Day6_1();
	}
}
