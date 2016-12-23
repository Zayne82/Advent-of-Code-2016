
public class Day3_2 {
	
	Day3_2(){
		//String[] rawInput = {"   5    10    25  "}; //Should give answer 1 invalid triangle.
		//String[] rawInput = {"   5    10    15  ","   5    10    25  "}; //Should give answer 0 invalid triangle.
		String[] rawInput = new FileReader().readLines("input/Day3_1_input.txt");
		int numInvalid 	= 0;
		int numValid 	= 0;
		int[][] input = new int[rawInput.length][3];
		
		System.out.println("Parse String to int.");
		for(int i = 0; i < rawInput.length; i++){
			String[] inputString = rawInput[i].trim().split("\\s{1,}");
			for(int j = 0; j < inputString.length; j++){
				input[i][j] = Integer.parseInt(inputString[j]);
				//System.out.println("String " + j + ":\"" + input[j] + "\"");
			}
		}
		System.out.println("Examine triangles.");
		for(int j = 0; j < 3; j++){
			
			for(int i = 0; i < rawInput.length - 2; i = i + 3){
				if(		(input[i][j]   + input[i+1][j] <= input[i+2][j]) || 
						(input[i][j]   + input[i+2][j] <= input[i+1][j]) || 
						(input[i+1][j] + input[i+2][j] <= input[i][j])){
					numInvalid++;
				}else{
					numValid++;
				}
			}
		}
		System.out.println("Number of valid triangles:   " + numValid);
		System.out.println("Number of invalid triangles: " + numInvalid);
	}
	
	public static void main(String[] args) {
		new Day3_2();
	}

}
