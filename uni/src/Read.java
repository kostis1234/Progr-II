
    import java.io.*;
    import java.nio.file.Files;
    import java.nio.file.Paths;

    public class Read {

        public static void main(String[] args) {
            BufferedReader reader;

            try {
                reader = new BufferedReader(new FileReader("test.txt"));
                String line = reader.readLine();
                File myObj = new File("test.txt");
                String line32 = Files.readAllLines(Paths.get("test.txt")).get(1);
                System.out.println(line32);
                FileWriter myWriter = new FileWriter("test.txt");
                while (line != null) {
                    System.out.println(line);
                    // read next line
                    line = reader.readLine();
                }
              myWriter.flush();
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}
