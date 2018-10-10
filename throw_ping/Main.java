import java.io.*;

public class Main {

    public static String execute(String command) {
        StringBuffer res = new StringBuffer();
		try {
			Process p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;			
			while ((line = reader.readLine())!= null) {
			    res.append(line);
                res.append(System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res.toString();
    }
    
    public static void main(String args[]) {
        System.out.println("length min avg max mdev");
        for (int i = 1; i < 15; ++i) {
            String bits = Integer.toString(i * 100);
            String command = "ping google.com -c 10 -s " + bits;
            String res = execute(command);
            String[] parts = res.split("/");
            System.out.println(parts[3].split(" = ")[1] + " " + parts[4] + " " + parts[5] + " " + parts[6].split(" ")[0]);
        }
    }
}
