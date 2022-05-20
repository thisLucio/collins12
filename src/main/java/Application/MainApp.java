package Application;

import Service.ResolveExpression;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp {
    //([0-9]?\s?[0-9]?\s?[/+*-]?\s?[0-9]*);?\n?
    private static final Pattern p = Pattern.compile("&(.*)&;\\n?");
    public static void main(String[] args) throws IOException {
        String directoryName = System.getProperty("user.dir");
        String fileName = directoryName + "/" + args[0];
        if (!fileName.endsWith("last")) {
            throw new RuntimeException("This is not a Last File.");
        } else {
            String content = readFile(fileName);
            ResolveExpression str = new ResolveExpression();
            Matcher m = p.matcher(content);
            ArrayList match = new ArrayList();

            while(m.find()) {
                match.add(m.group(1));
            }

            for(int i = 0; i < match.size(); ++i) {
                String[] auxExp = ((String)match.get(i)).split(" ");
                float result = (float)str.resolveExp(auxExp);
                System.out.println(result);
            }
        }
    }

    public static String readFile(String filename) throws IOException {
        String content = null;
        File file = new File(filename); // For example, foo.txt
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
