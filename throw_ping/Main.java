import java.io.*;

public class Main {

    public static String execute(String bits) {
        String command = "ping www.google.com -c 10 -s " + bits;
        String res = "";
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";			
			while ((line = reader.readLine())!= null) {
				if (line.contains("rtt")) return line;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
    }
    
    public static void main(String args[]) {
        for (int i = 1; i < 15; ++i) {
            String bits = Integer.toString(i*100);
            String res = execute(bits);
            System.out.println(res);
            String[] parts = res.split("/");
            System.out.println(parts[4]);
        }
    }
}
