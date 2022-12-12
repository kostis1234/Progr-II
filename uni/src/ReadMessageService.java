import java.io.IOException;

public interface ReadMessageService {
    void readMessage(String name);
    void like(String message,String name) throws IOException;
}
