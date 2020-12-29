
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws IOException {
        try (InputStream is =
                     Application.class.getResourceAsStream("/application.properties")){
            Properties p = new Properties();
            p.load(is);
            System.out.println(p);
        }
    }
}
