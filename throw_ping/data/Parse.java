import java.io.*;

public class Parse {
    
    public static void main(String args[]) {
        try {
            System.out.println("target, ip, data bytes, bytes, packets transmitted, received, packet loss (%), time (all in ms), rtt min, rtt avg, rtt max, rtt mdev, ipg, ewma, pipe");
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                System.out.print(tokens[1] + ", " + tokens[2].replace("(", "").replace(")", "") + ", ");
                String[] tbytes = tokens[3].replace("(", " ").split(" ");
                System.out.print(tbytes[0] + ", " + tbytes[1].replace(")", "") + ", ");
                line = reader.readLine();
                line = reader.readLine();
                tokens = line.split(" ");
                System.out.print(tokens[0] + ", " + tokens[3] + ", " + tokens[5].replace("%", "") + ", " + tokens[9].replace("ms", "") + ", ");
                line = reader.readLine();
                tokens = line.split(" ");
                String times = tokens[3].replace("/", ", ");
                String pipe = tokens[6].replace(",", "");
                String otimes = tokens[8].replace("/", ", ");
                System.out.println(times + ", " + otimes + ", " + pipe);
                line = reader.readLine();
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
