import java.io.*;
import java.util.Scanner;

public class SendMessageImpl implements SendMessage{

    @Override
    public void sendMessages(String name) throws IOException {
        System.out.println("Text the user you want to send a message to");
        Scanner obj = new Scanner(System.in);
        String username = (String) obj.nextLine();
        if(countWord(username) == 1) {
            System.out.println("Type your message");
            String message = (String) obj.nextLine();
            FileWriter fw = new FileWriter(username +".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(message + " from " + name);
            out.close();
        }else {
            System.out.println("This user does not exist!");
        }


    }
    public static int countWord(String word) throws FileNotFoundException {
        int flag = 0;
        Scanner scanner = new Scanner(new File("usernames.txt"));
        while (scanner.hasNext()) {
            String aString = scanner.nextLine();
            if (aString.equalsIgnoreCase(word)) {
                flag = 1;
            }
        }
        return flag;
    }
}
