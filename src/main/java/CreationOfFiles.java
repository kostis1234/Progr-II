import java.io.File;
import java.io.IOException;

public class CreationOfFiles {
    //This class is used only one time to create two txt files!
    public static void main(String[] args) {
        try{
            File file = new File("usernames.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("The creation did not occurred!");
        }
        try{
            File obj = new File("passwords.txt");
            if (obj.createNewFile()) {
                System.out.println("File created: " + obj.getName());
            }
        } catch (IOException e) {
            System.out.println("The creation did not occurred!");
        }
    }
}