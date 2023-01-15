import java.io.*;
import java.util.Scanner;

public class ReadMessageImpl implements ReadMessageService {
    @Override
    public void readMessage(String name) {
        BufferedReader reader;
        try {
            //Opening the correct txt file via the given username.
            reader = new BufferedReader(new FileReader(name + ".txt"));
            String line = reader.readLine();
            FileWriter myWriter = new FileWriter(name + ".txt");
            if (line == null) {
                System.out.println("No messages!");
            }
            while (line != null) {
                System.out.println(line);
                System.out.println("Do you want to like the message? *If so type Yes*");
                Scanner obj = new Scanner(System.in);
                String answer = obj.nextLine();
                //Ignoring caps case.
                if (answer.equalsIgnoreCase("Yes")) {
                    like(line, name);
                }
                line = reader.readLine();
            }
            //Delete the messages when the user reads them.
            myWriter.flush();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void like(String message, String name) throws IOException {
        //Splitting the line of the message and taking the last word which is the username of the user who send it.
        String[] parts = message.split(" ");
        String lastWord = parts[parts.length - 1];
        //Opening the sender's txt file and sending the message of the like.
        FileWriter fw = new FileWriter(lastWord + ".txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(name + " liked your message!");
        out.close();

    }
}