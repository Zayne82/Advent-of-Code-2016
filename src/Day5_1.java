import java.security.*;
import java.math.*;
import java.nio.charset.StandardCharsets;

public class Day5_1 {
	Day5_1(){
		//String test = "abc"; //Should give password "18f47a30"
		String doorID = "ugkcyxxp"; 
		//String firstDigit = "abc3231929"; // Should generate 1.
		
		int characters = 0;
		int seed = 0;
		String key = "";
		System.out.println("Starting search algorithm.");
		while(characters < 8){
			boolean foundCharacter = false;
			String hash = "";
			while(!foundCharacter){
				hash = generateMD5(doorID.concat(Integer.toString(seed)));
				if(hash.substring(0, 5).compareTo("00000") == 0){
					System.out.println("Found digit number " + (characters + 1) + ": '" + hash.substring(5,6) + "' at seed:" + seed);
					foundCharacter = true;
					key = key.concat(hash.substring(5,6));
				}
				if(seed % 100000 == 0){
						System.out.println("Seed:" + seed);
				}
				seed++;
			}
			characters++;
		}
		System.out.println("Stopping search algorithm.");
		System.out.println("Found key: \"" + key + "\"");
		
	}
	/*
	private String generateMD5_A(String input){
		//Much slower than the algorithm in generateMD5_2.
		String checksum = "";
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(input.getBytes("UTF-8"));
           
            //converting byte array to Hexadecimal String
           StringBuilder sb = new StringBuilder(2*hash.length);
           for(byte b : hash){
               sb.append(String.format("%02x", b&0xff));
           }
           checksum = sb.toString();
        }
		catch(Exception e){
			System.out.println("Exception: " + e.toString());
		}
		return checksum;
	}
	*/
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
		new Day5_1();

	}

}
