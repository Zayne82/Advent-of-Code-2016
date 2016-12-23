public class Day2_2 {
	int posX = 0;
	int posY = 2;
	char[][] keypad = new char[][]{{'\0','\0','1','\0','\0'},{'\0','2','3','4','\0'},{'5','6','7','8','9'},{'\0','A','B','C','\0'},{'\0','\0','D','\0','\0'}};
	
	void move(char direction){
		if(direction == 'D'){
			if(posY < 4){
				posY++;
				if(keypad[posY][posX] == '\0'){
					posY--;
				}
			}
			
		}
		if(direction == 'R'){
			if(posX < 4){
				posX++;
				if(keypad[posY][posX] == '\0'){
					posX--;
				}
			}
		}
		if(direction == 'U'){
			if(posY > 0){
				posY--;
				if(keypad[posY][posX] == '\0'){
					posY++;
				}
			}
		}
		if(direction == 'L'){
			if(posX > 0){
				posX--;
				if(keypad[posY][posX] == '\0'){
					posX++;
				}
			}
		}
	}
	char getKey(){
		return keypad[posY][posX];
	}
	
	Day2_2(){
		String[] input = null;
		FileReader fr = new FileReader();
		//input = fr.readLines("input/Day2_1_validation_input.txt"); //Should give answer: 5DB3
		input = fr.readLines("input/Day2_1_input.txt");
		
		System.out.println("Start at key:" + getKey());
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < input[i].length(); j++){
				move(input[i].charAt(j));
			}
			System.out.println("Kay at line " + i + ": " + getKey());
		}
	}
	
	public static void main(String[] args) {
		new Day2_2();
	}

}
