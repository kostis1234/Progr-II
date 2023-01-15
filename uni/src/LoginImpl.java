import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class LoginImpl implements LoginInterface {
    protected static String username;

    public static String getName() {
        return username;
    }
    @Override
    public boolean login() throws IOException {
        //Success being used as a flag;if the user logged in successfully or not.
        boolean success = false;
        boolean end = true;
        System.out.println("Please type your username");
        Scanner obj = new Scanner(System.in);
        username = obj.nextLine();
        //creating an object for our txt file.
        File usernames1 = new File("usernames.txt");
        //The following loop allows the user to type the username/password until the correct match!
        while (end) {
            if (countWord(username, usernames1) == 0) {
                System.out.println("The username wasn't found!");
                System.out.println("Wanna try again? *If so type yes*");
                Scanner obj1 = new Scanner(System.in);
                String answer = obj1.nextLine();
                if(answer.equalsIgnoreCase("Yes")){
                    System.out.println("Please type your username");
                    username = obj.nextLine();
                }else {
                    end = false;
                }
            } else {
                System.out.println("Please type your password");
                String password = obj.nextLine();
                int line = findLine(username);
                //These two txt files are parallel which means that in the same line we have both username and password of the user.
                String correctPassword = Files.readAllLines(Paths.get("passwords.txt")).get(line - 1);
                if (Objects.equals(correctPassword, password)) {
                    System.out.println("You logged in successfully!");
                    success = true;
                    end = false;
                } else {
                    System.out.println("Sorry;wrong password!");
                    System.out.println("Do you want to try again? *Type Yes*");
                    Scanner obj2 = new Scanner(System.in);
                    String answer = obj2.nextLine();
                    if(!answer.equalsIgnoreCase("Yes")){
                        end = false;
                    }
                }
            }
        }
        return success;
    }


    public int countWord(String word, File file) throws FileNotFoundException {
        int count = 0;
        // Count works as a flag as well.If it is 0 it means that the username does not exist.
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String nextToken = scanner.nextLine();
            if (nextToken.equals(word))
                count++;
        }
        return count;
    }

    public static int findLine(String word) {
        //Trying to find the specific line which contains our user's info.
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("usernames.txt"))) {
            String line;
            int counter = 1;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    lines = counter;
                }
                counter++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
