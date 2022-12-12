import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Controller {
    public static LoginImpl login = new LoginImpl();
    public static RegisterServiceImpl registerService = new RegisterServiceImpl();
    public static SendMessageImpl sendMessage = new SendMessageImpl();
    public static ReadMessageImpl readMessage = new ReadMessageImpl();


    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our app!");
        System.out.println("For login type Yes");
        Scanner obj = new Scanner(System.in);
        String answer = obj.nextLine();
        if (Objects.equals(answer, "Yes")) {
            System.out.println("For login press 1");
            System.out.println("For register press 2");
            Scanner obj2 = new Scanner(System.in);
            int answer2 = obj2.nextInt();
            boolean success = false;
            String username = null;
            if (answer2 == 1) {
                 success = login.login();
                 username = LoginImpl.getName();
            } else if (answer2 == 2) {
                 success =  registerService.register();
                 username = RegisterServiceImpl.getName();
            }
            if(success) {
                System.out.println("To logout type 3");
                System.out.println("To read messages type 4");
                System.out.println("To send messages type 5");
                int finalAnswer = obj2.nextInt();
                while(finalAnswer !=3 ) {
                    if(finalAnswer == 4){
                        readMessage.readMessage(username);
                    } else if (finalAnswer == 5) {
                        sendMessage.sendMessages(username);
                    }
                    System.out.println("For logout press 3");
                    System.out.println("For reading messages type 4");
                    System.out.println("For sending messages type 5");
                    finalAnswer = obj2.nextInt();
                }
            }

        } else {
            System.out.println("Thanks for your time!");
        }
    }
}
