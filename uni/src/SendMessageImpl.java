import java.io.*;
import java.util.Scanner;

public class SendMessageImpl implements SendMessage {

    @Override
    public void sendMessages(String name) throws IOException {
        System.out.println("Text the user you want to send a message to");
        Scanner obj = new Scanner(System.in);
        String username = obj.nextLine();
        boolean end = true;
        //The following loop allows the user to type the username until the correct one!
        while (end) {
            if (countWord(username) == 1) {
                System.out.println("Type your message");
                String message = obj.nextLine();
                //Opening the receiver's txt file and adding the message.
                FileWriter fw = new FileWriter(username + ".txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw);
                out.println(message + " from " + name);
                out.close();
                end = false;
            } else {
                System.out.println("Oops...This user does not exist!");
                System.out.println("Do you want to try again? *If so type Yes*");
                Scanner obj1 = new Scanner(System.in);
                String answer = obj1.nextLine();
                if (answer.equalsIgnoreCase("Yes")) {
                    System.out.println("Please type your username");
                    username = obj.nextLine();
                } else {
                    end = false;
                }
            }
        }
    }

    public static int countWord(String word) throws FileNotFoundException {
        // Flag works as a flag.If it is 0 it means that the username does not exist.
        int flag = 0;
        Scanner scanner = new Scanner(new File("usernames.txt"));
        while (scanner.hasNext()) {
            String aString = scanner.nextLine();
            if (aString.equals(word)) {
                flag = 1;
            }
        }
        return flag;
    }
}
