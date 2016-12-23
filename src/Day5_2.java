import java.security.*;
import java.math.*;
import java.nio.charset.StandardCharsets;

public class Day5_2 {
	Day5_2(){
		//String test = "abc"; //Should give password "05ace8e3"
		String doorID = "ugkcyxxp"; 
		//String firstDigit = "abc3231929"; // Should generate 1.
		
		int characters = 0;
		int seed = 0;
		char[] key = new char[8];
		
		System.out.println("Starting search algorithm.");
		while(characters < 8){
			boolean foundCharacter = false;
			String hash = "";
			while(!foundCharacter){
				hash = generateMD5(doorID.concat(Integer.toString(seed)));
				//hash = generateMD5(test.concat(Integer.toString(seed)));
				if(hash.substring(0, 5).compareTo("00000") == 0){
					System.out.println("Found potential digit: '" + hash.substring(6,7) + "' at seed:" + seed);
					char pos = hash.substring(5,6).toCharArray()[0]; 
					if(pos < '8'){
						if(key[pos-48] == 0){
							System.out.println("Position was valid. Found position: " + (pos-48)); 
							key[pos-48] = hash.substring(6,7).toCharArray()[0];
							System.out.print("Current key: '");
							for(int i = 0; i < 8; i++){
								if(key[i] != 0){
									System.out.print(key[i]);
								}
								else{
									System.out.print(" ");
								}
								
							}
							System.out.println("'");
							foundCharacter = true;
						}
						else{
							System.out.println("Position already filled. Continuing.");
						}
					}
					else{
						System.out.println("Position was not valid. Continuing.");
					}
				}
				if(seed % 100000 == 0){
						//System.out.println("Seed:" + seed);
				}
				seed++;
			}
			characters++;
		}
		String keyString = new String(key);
		System.out.println("Stopping search algorithm.");
		System.out.println("Found key: \"" + keyString + "\"");
		
	}

	private String generateMD5(String input){
		try{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(StandardCharsets.UTF_8.encode(input));
			return String.format("%032x", new BigInteger(1, md5.digest()));
		}
		catch(Exception e){
			System.out.println("Exception: " + e.toString());
		}
		return "";
	}

	public static void main(String[] args) {
		new Day5_2();

	}


}
