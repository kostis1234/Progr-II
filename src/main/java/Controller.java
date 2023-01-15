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
        Scanner obj2 = new Scanner(System.in);
        boolean success = false;
        String username = null;
        boolean done = true;
        while (done) {
            System.out.println("""
                    *To login type 1
                    *To register type 2
                    *To shut down the app type 3""");
            String answer2 = obj2.nextLine();
            if (Objects.equals(answer2, "1")) {
                success = login.login();
                username = LoginImpl.getName();
                done = false;
            } else if (Objects.equals(answer2, "2")) {
                success = registerService.register();
                username = RegisterServiceImpl.getName();
                done = false;
            } else if(Objects.equals(answer2,"3")) {
                done = false;
            }else{
                System.out.println("Non existing answer;try again!");
            }
        }
        if (success) {
            System.out.println("To logout type 3");
            System.out.println("To read messages type 4");
            System.out.println("To send messages type 5");
            String finalAnswer = obj2.nextLine();
            while (!Objects.equals(finalAnswer, "3")) {
                if (Objects.equals(finalAnswer, "4")) {
                    readMessage.readMessage(username);
                } else if (Objects.equals(finalAnswer, "5")) {
                    sendMessage.sendMessages(username);
                } else {
                    System.out.println("Non existing answer;try again!");
                }
                System.out.println("To logout type 3");
                System.out.println("To read messages type 4");
                System.out.println("To send messages type 5");
                finalAnswer = obj2.nextLine();
            }
        }
        System.out.println("Thank you for your time!");
    }
}
