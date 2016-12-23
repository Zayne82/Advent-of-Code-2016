
import java.util.Vector;
public class Day1_2 {

String input = "R1, R1, R3, R1, R1, L2, R5, L2, R5, R1, R4, L2, R3, L3, R4, L5, R4, R4, R1, L5, L4, R5, R3, L1, R4, R3, L2, L1, R3, L4, R3, L2, R5, R190, R3, R5, L5, L1, R54, L3, L4, L1, R4, R1, R3, L1, L1, R2, L2, R2, R5, L3, R4, R76, L3, R4, R191, R5, R5, L5, L4, L5, L3, R1, R3, R2, L2, L2, L4, L5, L4, R5, R4, R4, R2, R3, R4, L3, L2, R5, R3, L2, L1, R2, L3, R2, L1, L1, R1, L3, R5, L5, L1, L2, R5, R3, L3, R3, R5, R2, R5, R5, L5, L5, R2, L3, L5, L2, L1, R2, R2, L2, R2, L3, L2, R3, L5, R4, L4, L5, R3, L4, R1, R3, R2, R4, L2, L3, R2, L5, R5, R4, L2, R4, L1, L3, L1, L3, R1, R2, R1, L5, R5, R3, L3, L3, L2, R4, R2, L5, L1, L1, L5, L4, L1, L1, R1";
	
	int posX = 0;
	int posY = 0;
	int direction = 0;
	void turnRight(){
		direction++;
		if(direction > 3){
			direction = 0;
		}
	}
	void turnLeft(){
		direction--;
		if(direction < 0){
			direction = 3;
		}
	}
	void move(int numSteps){
		if(direction == 0){
			posX += numSteps;
		}
		if(direction == 1){
			posY += numSteps;
		}
		if(direction == 2){
			posX -= numSteps;
		}
		if(direction == 3){
			posY -= numSteps;
		}
	}

	Day1_2(){
		//Iterate through the input and update position.
		Vector<String> visitedPositions = new Vector<String>();
		String tmpPos = "";
		String[] splitInput = input.split(", ");
		for(int i = 0; i < splitInput.length; i++){
			if(splitInput[i].charAt(0)== 'R'){
				turnRight();
			}else{
				turnLeft();
			}
			move(Integer.parseInt(splitInput[i].substring(1)));
			tmpPos = Integer.toString(posX) + "x" + Integer.toString(posY);
			System.out.println(tmpPos);
			//Check earlier positions
			if(visitedPositions.size() > 0){
				if(visitedPositions.contains(tmpPos)){  //FIXA!
					System.out.println("First position to be visited twice: " + posX + "x" + posY);
					System.out.println("Distance from starting position: " + (Math.abs(posX) + Math.abs(posY)));
					break;
				}
				
			}else{
				visitedPositions.add(tmpPos);
			}
		}
		System.out.println("Position: " + posX + "," + posY);
		System.out.println("Distance from starting position: " + (Math.abs(posX) + Math.abs(posY)));
	}
	public static void main(String[] args) {
		new Day1_2();
	}

}
