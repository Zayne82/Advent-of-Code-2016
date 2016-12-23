import java.util.Arrays;
import java.util.Vector;

public class Day4_1 {
	Day4_1(){
				
		int idSum = 0;
		//String[] rawInput = new FileReader().readLines("input/Day4_1_validation_input.txt"); //Should give answer 1514.
		String[] rawInput = new FileReader().readLines("input/Day4_1_input.txt");
		for(int i = 0; i < rawInput.length; i++){
			String input 	= rawInput[i].substring(0,rawInput[i].lastIndexOf("-")).replace("-", "");
			String id 		= rawInput[i].substring(rawInput[i].lastIndexOf("-") + 1, rawInput[i].indexOf("["));
			String checksum = rawInput[i].substring(rawInput[i].indexOf("[") + 1, rawInput[i].length() - 1);
			
			if(calculateChecksum(input).compareTo(checksum) == 0){
				idSum += Integer.parseInt(id);
			}
		}
		System.out.println("The sum of the id's of the valid rooms is: " + idSum);
	}
	
	private String calculateChecksum(String input){
		String checksum = "";
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
		new Day4_1();
	}
	
	private class Letter{
		char letter;
		int occurrences = 0;
		Letter(char letter){
			this.letter = letter;
			this.occurrences = 1;
		}
	}
}
