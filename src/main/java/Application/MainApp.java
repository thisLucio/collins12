package Application;

import Service.ResolveExpression;

public class MainApp {
    public static void main(String[] args) {

        String[] exp = new String[]{"7","3","+", "4", "+"};

        ResolveExpression str = new ResolveExpression();
        int result = str.resolveExp(exp);
        System.out.println(result);

    }
}
