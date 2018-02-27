import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderImpl {
    static String processFile(ProcessBufferReader reader) throws IOException {
        try (BufferedReader bReader = new BufferedReader(new FileReader("C:\\Users\\AB PAVILION\\Desktop\\Hurts.txt"));) {
            return reader.process(bReader);
        }
    }

    public static void main(String[] args){
        try {
            String readFile=processFile((BufferedReader br)->br.readLine()+br.readLine());
            System.out.println(readFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
