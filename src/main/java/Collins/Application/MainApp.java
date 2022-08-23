package Collins.Application;

import Collins.Parser.Parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainApp {
    //([0-9]?\s?[0-9]?\s?[/+*-]?\s?[0-9]*);?\n?
    public static void main(String[] args) throws IOException {
        String directoryName = System.getProperty("user.dir");
        String fileName = directoryName + "/" + args[0];
        if (!fileName.endsWith("st")) {
            throw new RuntimeException("This is not a Stely File.");
        } else {
            String content = readFile(fileName);
            Parser parser = new Parser();
            parser.getStelyPackage(content);

         //   RpnModule rpn = new RpnModule();
           // rpn.RPN(content);
        }
    }

    public static String readFile(String filename) throws IOException {
        String content = null;
        File file = new File(filename);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                reader.close();
            }
        }
        return content;
    }
}
