package Parser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Parser {
    private static final Pattern packStely = Pattern.compile("^pack\\sStely;\\n([\\s\\S]*)$");
    public static final Pattern mainFunction = Pattern.compile("main*(\\n?.*\\n?)}");
    private String body;

    public void getStelyPackage(String content){
        try {
            Matcher m = packStely.matcher(content);
            if(m.find()) {
                mainFunction();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void mainFunction(){
        try {
            Matcher m = mainFunction.matcher(body);
            if(m.find()) {
                String content = m.group(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
