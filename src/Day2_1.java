public class Day2_1 {
	int posX = 1;
	int posY = 1;
	int[][] keypad = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
	
	void move(char direction){
		if(direction == 'D'){
			if(posY < 2) posY++;
		}
		if(direction == 'R'){
			if(posX < 2) posX++;
		}
		if(direction == 'U'){
			if(posY > 0)posY--;
		}
		if(direction == 'L'){
			if(posX > 0) posX--;
		}
	}
	int getKey(){
		return keypad[posY][posX];
	}
	
	Day2_1(){
		//String[] input = {"ULL", "RRDDD", "LURDL", "UUUUD"}; //Validation, should give answer 1985.
		//String inputRaw = ""; 
		String[] input = null;
		FileReader fr = new FileReader();
		//input = fr.readLines("input/Day2_1_validation_input.txt");
		input = fr.readLines("input/Day2_1_input.txt");
		
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < input[i].length(); j++){
				move(input[i].charAt(j));
			}
			System.out.println("Kay at line " + i + ": " + getKey());
		}
	}
	
	public static void main(String[] args) {
		new Day2_1();
	}

}
