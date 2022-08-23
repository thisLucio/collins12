package Collins.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RpnModule {

    private static final Pattern p = Pattern.compile("&(.*)&;\\n?");

    public RpnModule() {
    }

    public float RPN(String content){
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
        return 0;
    }

}
