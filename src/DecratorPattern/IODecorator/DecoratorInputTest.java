package DecratorPattern.IODecorator;

import java.io.*;

public class DecoratorInputTest {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new LowerCaseInputStream(new BufferedInputStream(new ByteArrayInputStream("asdf".getBytes())));
            int c;
            while (( c = inputStream.read()) >=0){
                System.out.println((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
