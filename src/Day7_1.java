
public class Day7_1 {
	Day7_1(){
		String example1 = "abba[mnop]qrst"; 		//True
		String example2 = "abcd[bddb]xyyx"; 		//False
		String example3 = "aaaa[qwer]tyui"; 		//False
		String example4 = "ioxxoj[asdfgh]zxcvbn"; 	//True
		String example5 = "[mikael][cederlof][malin]cederlof[slut]";
		
		System.out.println("Find Hypernet sequences.");
		getHypernetSequences(example4);
		System.out.println("Find non Hypernet sequences.");
		getNonHypernetParts(example1);
		/*
		if(checkString("ioxxoj")){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
		*/
	}
	
	private boolean checkString(String input){
		for(int i = 0; i < input.length() - 3; i++){
			if(		input.charAt(i) 	== input.charAt(i+3) && 
					input.charAt(i+1) 	== input.charAt(i+2) && 
					input.charAt(i) 	!= input.charAt(i+1)){
				return true;
			}
		}
		return false;
	}
	
	private String[] getHypernetSequences(String input){
		int numHyp = 0;
		int pos = -1;
		while((pos = input.indexOf("[", pos + 1)) != -1){
			numHyp++;
		}
		String[] result = new String[numHyp];
		pos = 0;
		for(int i = 0; i < numHyp; i++){
			result[i] = input.substring(pos = input.indexOf("[", pos) + 1, pos = input.indexOf("]", pos));
			System.out.println("Found Hypernet sequence: " + result[i]);
		}
		return result;
	}
	
	private String[] getNonHypernetParts(String input){
		String[] parts = input.split("\\[");
		int numParts = 0;
		for(int i = 0; i < parts.length; i++){
			if(!parts[i].endsWith("]")){
				numParts++;
			}
		}
		System.out.println("Found " + numParts + " sequences.");
		String[] result = new String[numParts];
		for(int i = 0; i < parts.length; i++){
			if(!parts[i].endsWith("]")){
				System.out.println("Found a non hypernet sequence.");
				result[numParts - 1] = parts[i];
				System.out.println("Non Hypernet sequence: " + result[numParts]);
				numParts--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		new Day7_1();
	}

}
