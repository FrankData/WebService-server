package output;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class GenerateReport {
	
	static public void report(String source, String fileName){
		String path = "C:/Users/grace/workspace/secureWS/output/" + fileName + ".xml"; 
		        try {
					PrintWriter pw = new PrintWriter(path);
					pw.print(source);
					pw.flush();
					pw.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
}
