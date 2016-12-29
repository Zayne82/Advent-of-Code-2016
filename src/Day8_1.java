
public class Day8_1 {
	char[][] screen;
	char active = '0';
	Day8_1(){
		/*
		generateScreen(7, 3);
		turnOnRect(3, 2);
		System.out.println("Active pixels = " + countActivePixels());
		printScreen();
		shiftColumn(1, 1);
		printScreen();
		shiftRow(0, 4);
		printScreen();
		shiftColumn(1, 1);
		printScreen();
		*/
		
		String[] input = new FileReader().readLines("input/Day8_1_input.txt");
		generateScreen(50, 6);
		//String[] input = new FileReader().readLines("input/Day8_1_validation.txt");
		//generateScreen(7, 3);
		for(int i = 0; i < input.length; i++){
			readInput(input[i]);
		}
		printScreen();
		System.out.println("Number of active pixels: " + countActivePixels());
	}
	
	private void readInput(String input){
		String[] parts = input.split(" ");
		//Create rect
		if(parts[0].compareTo("rect") == 0){
			String[] coords = parts[1].split("x");
			turnOnRect(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
			return;
		}
		//Rotate row
		if(parts[1].compareTo("row") == 0){
			shiftRow(Integer.parseInt(parts[2].split("=")[1]), Integer.parseInt(parts[4]));
		}
		//Rotate column
		if(parts[1].compareTo("column") == 0){
			shiftColumn(Integer.parseInt(parts[2].split("=")[1]), Integer.parseInt(parts[4]));
		}
	}
	
	private int countActivePixels(){
		int active = 0;
		for(int i = 0; i < screen.length; i++){
			for (int j = 0; j < screen[0].length; j++){
				if(screen[i][j] == '#'){
					active++;
				}
			}
		}
		return active;
	}
	
	private void shiftRow(int row, int steps){
		//Take care of too large shifts.
		int step = steps % screen[0].length;
		if( row < screen.length){
			char[] tmp = new char[screen[0].length];
			//Create shifted row.
			for(int i = 0; i < tmp.length; i++){
				if( i + step >= tmp.length){
					tmp[i + step - tmp.length] = screen[row][i];
				}
				else{
					tmp[i + step] = screen[row][i];
				}
			}
			//Assign shifted row.
			screen[row] = tmp;
		}
		else{
			System.out.println("shiftRow: Row out of bounds.");
		}
	}
	
	private void shiftColumn(int col, int steps){
		//Take care of too large shifts.
		int step = steps % screen.length;
		if( col < screen[0].length){
			char[] tmp = new char[screen.length];
			//Create shifted column.
			for(int i = 0; i < tmp.length; i++){
				if( i + step >= tmp.length){
					tmp[i + step - tmp.length] = screen[i][col];
				}
				else{
					tmp[i + step] = screen[i][col];
				}
			}
			//Assign shifted column.
			for(int i = 0; i < tmp.length; i++){
				screen[i][col] = tmp[i];
			}
		}
		else{
			System.out.println("shiftColumn: Column out of bounds.");
		}
	}
	
	private void generateScreen(int x, int y){
		screen = new char[y][x];
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				screen[i][j] = ' ';
			}
		}
	}
	
	private void turnOnRect(int x, int y){
		if( y < screen.length){
			if(x < screen[0].length){
				for(int i = 0; i < y; i++){
					for(int j = 0; j < x; j++){
						screen[i][j] = '#';
					}
				}
			}
			else{
				System.out.println("turnOnRect: Column out of bounds.");
			}
		}
		else{
			System.out.println("turnOnRect: Row out of bounds.");
		}
	}
	
	private void printScreen(){
		if(screen != null){
			System.out.println("Screen:");
			for(int i = 0; i < screen.length; i++){
				//System.out.println("\"" + new String(screen[i]) + "\"");
				System.out.println(new String(screen[i]));
			}
		}
	}

	public static void main(String[] args) {
		new Day8_1();
	}

}
