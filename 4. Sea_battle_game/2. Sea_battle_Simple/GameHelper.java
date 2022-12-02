import java.io.*;
public class GameHelper {
    public String getUserInput(String promt) { //prompt - незамедлительный

        String inputLine = null;
        System.out.print(promt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.print("IOException: " + e);
        }
        return inputLine;
    }
}
