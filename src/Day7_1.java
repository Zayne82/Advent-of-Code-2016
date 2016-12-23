
public class Day7_1 {
	Day7_1(){
		String example1 = "abba[mnop]qrst"; 		//True
		String example2 = "abcd[bddb]xyyx"; 		//False
		String example3 = "aaaa[qwer]tyui"; 		//False
		String example4 = "ioxxoj[asdfgh]zxcvbn"; 	//True
		
		
		/*
		if(checkString("ioxxoj")){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
		*/
	}
	boolean checkString(String input){
		for(int i = 0; i < input.length() - 3; i++){
			if(		input.charAt(i) 	== input.charAt(i+3) && 
					input.charAt(i+1) 	== input.charAt(i+2) && 
					input.charAt(i) 	!= input.charAt(i+1)){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new Day7_1();
	}

}
