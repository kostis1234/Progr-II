import java.io.*;
import java.util.Scanner;

public class RegisterServiceImpl implements RegisterService {
    protected static String name;

    public static String getName() {
        return name;
    }

    @Override
    public boolean register() throws IOException {
        //Success being used as a flag;if the user logged in successfully or not.
        boolean success = false;
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter a username");
        name =  obj.nextLine();
        boolean end = true;
        //This loop allows the user to try multiple usernames until the success sign up.
        while(end) {
            //Checking if the username already exists.
            if (countWord(name) != 0) {
                System.out.println("Sorry this username is in use!");
                Scanner obj2 = new Scanner(System.in);
                System.out.println("Do you want to try again? *Type Yes*");
                String answer = obj2.nextLine();
                if(answer.equalsIgnoreCase("Yes")){
                    System.out.println("Enter a username");
                    name =  obj.nextLine();
                }else {
                    end = false;
                }
            } else {
                System.out.println("Enter a password");
                String password = obj.nextLine();
                //Adding the password and the username to txt files.
                FileWriter username = new FileWriter("usernames.txt", true);
                BufferedWriter writer = new BufferedWriter(username);
                PrintWriter print = new PrintWriter(writer);
                FileWriter pasSword = new FileWriter("passwords.txt", true);
                BufferedWriter writer1 = new BufferedWriter(pasSword);
                PrintWriter print1 = new PrintWriter(writer1);
                print.println(name);
                print1.println(password);
                //Creating a unique txt file naming it as the username.
                File myObj = new File(name + ".txt");
                myObj.createNewFile();
                print.close();
                print1.close();
                success = true;
                end = false;
            }
        }
        return success;
    }

    public static int countWord(String word) throws FileNotFoundException {
        int flag = 0;
        // Flag works as a flag.If it is 0 it means that the username does not exist.
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