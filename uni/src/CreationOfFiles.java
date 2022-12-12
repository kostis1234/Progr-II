import java.io.File;
import java.io.IOException;

public class CreationOfFiles {
    public static void main(String[] args) {
        try{
            File myObj = new File("usernames.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
        try{
            File myObj = new File("passwords.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
}
