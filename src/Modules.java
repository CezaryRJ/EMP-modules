import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Modules {

	public static void main(String[] args) throws IOException {

		System.out.println(compareFile(new File("test.txt"),new File("test1.txt")));

	}
	
	/***
	 * 
	 * @param file to be compared
	 * @param file to be compared
	 * @return a percentage of overlapping bytes
	 * @throws IOException
	 */
	public static double compareFile(File a, File b) throws IOException{
		
		Path tmp = Paths.get(a.getAbsolutePath());
		
		byte[] aByte = Files.readAllBytes(tmp);
		
		tmp = Paths.get(b.getAbsolutePath());
		
		byte[] bByte = Files.readAllBytes(tmp);
		
		int counter = 0;
		
		int smallestSize = 0;
		
		int largestSize = 0;
		
		if(aByte.length < bByte.length){
			smallestSize = aByte.length;
			largestSize = bByte.length;
		}
		else{
			smallestSize = bByte.length;
			largestSize = aByte.length;
		}
		
		for(int i = 0; i<smallestSize;i++){
			if(aByte[i] == bByte[i]){
				counter++;
			}
		}
		return((double)counter/(double)(largestSize));
		
	}

}
