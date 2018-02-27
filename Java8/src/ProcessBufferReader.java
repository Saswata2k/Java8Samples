import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface ProcessBufferReader {
    String process(BufferedReader reader) throws IOException;
}
