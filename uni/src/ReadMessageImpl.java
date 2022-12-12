import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ReadMessageImpl implements ReadMessageService{
    @Override
    public void readMessage(String name) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(name +".txt"));
            String line = reader.readLine();
            FileWriter myWriter = new FileWriter(name +".txt");
            if(line == null) {
                System.out.println("No messages!");
            }
            while (line != null) {
                System.out.println(line);
                System.out.println("Do you want to like the message?Yes/No");
                Scanner obj = new Scanner(System.in);
                String answer = obj.nextLine();
                if (Objects.equals(answer, "Yes")) {
                    like(line, name);
                }
                line = reader.readLine();
            }
            myWriter.flush();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void like(String message, String name) throws IOException {
        String[] parts = message.split(" ");
        String lastWord = parts[parts.length - 1];
        FileWriter fw = new FileWriter(lastWord +".txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(name + " liked your message!");
        out.close();

    }
}
