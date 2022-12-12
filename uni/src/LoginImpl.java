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
        boolean succcess;
        System.out.println("Type your username");
        Scanner obj = new Scanner(System.in);
         username = (String) obj.nextLine();
        System.out.println("Type your password");
        String password = (String) obj.nextLine();
        File usernames1 = new File("usernames.txt");
        if (countWord(username, usernames1) == 0) {
            System.out.println("The username wasn't found!");
            succcess = false;
        } else {
           int line = findLine(username);
            String correctPassword = Files.readAllLines(Paths.get("passwords.txt")).get(line-1);
            if(Objects.equals(correctPassword, password)) {
                System.out.println("You logged in successfully!");
                succcess = true;
            }else{
                System.out.println("Wrong password!");
                succcess = false;
            }
        }
        return succcess;
    }


    public int countWord(String word, File file) throws FileNotFoundException {
        int count = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String nextToken = scanner.nextLine();
            if (nextToken.equalsIgnoreCase(word))
                count++;
        }
        return count;
    }
    public static int findLine (String word){
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("usernames.txt"))) {
            String line;
            int counter = 1;
            while ((line = br.readLine()) != null) { //read file line by line in a loop
                if (line.contains(word)) { // check if line contain that word then prints the line
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
