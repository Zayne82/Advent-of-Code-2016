
public class Day3_1 {
	
	Day3_1(){
		//String[] rawInput = {"   5    10    25  "}; //Should give answer 1 invalid triangle.
		//String[] rawInput = {"   5    10    15  ","   5    10    25  "}; //Should give answer 0 invalid triangle.
		String[] rawInput = new FileReader().readLines("input/Day3_1_input.txt");
		int numInvalid 	= 0;
		int numValid 	= 0;
		
		for(int i = 0; i < rawInput.length; i++){
			String[] inputString = rawInput[i].trim().split("\\s{1,}");
			int[] input = new int[inputString.length];
			for(int j = 0; j < inputString.length; j++){
				input[j] = Integer.parseInt(inputString[j]);
				//System.out.println("String " + j + ":\"" + input[j] + "\"");
			}
			if((input[0] + input[1] <= input[2]) || (input[0] + input[2] <= input[1]) || (input[1] + input[2] <= input[0])){
				numInvalid++;
			}else{
				numValid++;
			}
		}
		System.out.println("Number of valid triangles:   " + numValid);
		System.out.println("Number of invalid triangles: " + numInvalid);
	}
	
	public static void main(String[] args) {
		new Day3_1();
	}

}
