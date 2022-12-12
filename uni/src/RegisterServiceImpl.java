import java.io.*;
import java.util.Scanner;

public class RegisterServiceImpl implements RegisterService {
    protected static String name;
    public static String getName() {
        return name;
    }
    @Override
    public boolean register() throws IOException {
        boolean success;
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter a username");
         name = (String) obj.nextLine();
        System.out.println("Enter a password");
        String password = (String) obj.nextLine();
        File file = new File("usernames.txt");
        if (countWord(name) != 0) {
            System.out.println("This username is in use!");
            success = false;
        } else {
            FileWriter fw = new FileWriter("usernames.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            FileWriter fw1 = new FileWriter("passwords.txt", true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter out1 = new PrintWriter(bw1);
            out.println(name);
            out1.println(password);
            File myObj = new File(name +".txt");
            myObj.createNewFile();

            out1.close();
            out.close();
            success = true;
        }
        return success;
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



