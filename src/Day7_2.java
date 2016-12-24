
public class Day7_2 {
	Day7_2(){
		String[] input = new FileReader().readLines("input/Day7_1_input.txt");
		int numValid = 0;
		for(int i = 0; i < input.length; i++){
			if(validateInput(input[i])){
				numValid++;
			}
		}
		
		System.out.println("A total of " + numValid + " lines are valid.");
	}
	
	private boolean validateInput(String input){
		String[] parts = getHypernetSequences(input);
		for(int i = 0; i < parts.length; i++){
			if(containsABBA(parts[i])){
				return false;
			}
		}
		parts = getSupernetSequences(input);
		for(int i = 0; i < parts.length; i++){
			if(containsABBA(parts[i])){
				return true;
			}
		}
		
		return false;
	}
	
	private boolean containsABA(String supernet, String[] hypernet){
		for(int i = 0; i < supernet.length() - 2; i++){
			if(		supernet.charAt(i) 	 == supernet.charAt(i+2) &&
					supernet.charAt(i) 	 != supernet.charAt(i+1)){
				
				return true;
			}
		}
		return false;
	}
	
	private boolean containsBAB(char a, char b, String[] hypernet){
		String bab = new String(new char[]{b,a,b});
		for(int i = 0; i < hypernet.length; i++){
			if(hypernet[i].contains(bab)){
				return true;
			}
		}
		return false;
	}
	
	private boolean containsABBA(String input){
		//System.out.println("Checking: " + input);
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
			//System.out.println("Found Hypernet sequence: " + result[i]);
		}
		return result;
	}
	
	private String[] getSupernetSequences(String input){
		String[] parts = input.split("\\[");
		int numParts = 0;
		for(int i = 0; i < parts.length; i++){
			if(!parts[i].endsWith("]") && parts[i].length() > 0){
				numParts++;
			}
		}
		String[] result = new String[numParts];
		//System.out.println("Found " + numParts + " parts.");
		for(int i = 0; i < parts.length; i++){
			if(!parts[i].endsWith("]") && parts[i].length() > 0){
				if(parts[i].indexOf("]") != -1){
					parts[i] = parts[i].substring(parts[i].indexOf("]") + 1, parts[i].length());
				}
				result[numParts - 1] = parts[i];
				//System.out.println("Non Hypernet sequence: " + result[numParts-1]);
				numParts--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		new Day7_2();
	}
}
