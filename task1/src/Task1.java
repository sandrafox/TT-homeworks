import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException, ParserException {
        Task1 task = new Task1();
        task.solve();
    }

    public void solve() throws IOException, ParserException {
        Scanner scanner = new Scanner(System.in).useDelimiter("\0");
        /*StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(" " + line);
        }*/
        Parser parser = new Parser();
        System.out.println(parser.parse(scanner.next()));
        scanner.close();
    }
}
