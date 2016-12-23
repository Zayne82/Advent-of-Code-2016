import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
	FileReader(){
	}
	public String[] readLines(String filePath){
		List<String> inputRaw = null; 
		try{
			Path file = Paths.get(filePath);
			inputRaw = Files.readAllLines(file);
			return inputRaw.toArray(new String[]{});
		}
		catch (IOException e){
			System.out.println(e);
		}
		return null;
	}
	public static void main(String[] args) {
		FileReader fr = new FileReader();
		System.out.println(fr.readLines("input/Day2_1_validation_input.txt")[0]);
	}
}
