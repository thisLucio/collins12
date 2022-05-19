package Service;

import java.util.Objects;
import java.util.Stack;

public class ResolveExpression {

    public int resolveExp(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        int x, y;
        String result = "";
        int get = 0;
        String choice;
        int value = 0;
        String p = "";
        for (String token : tokens) {
            if (!Objects.equals(token, "+") && !Objects.equals(token, "-")
                    && !Objects.equals(token, "*") && !Objects.equals(token, "/")) {
                stack.push(token);
                continue;
            } else {
                choice = token;
            }
            switch (choice) {
                case "+":

                    // Performing the "+" operation by poping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                    break;

                case "-":

                    // Performing the "-" operation by poping
                    // put the first two character
                    // and then again store back to the stack
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                    break;

                case "*":

                    // Performing the "*" operation
                    // by poping put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                    break;

                case "/":

                    // Performing the "/" operation by poping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                    break;

                default:
                    continue;
            }
        }

        // Method to convert the String to integer
        return Integer.parseInt(stack.pop());

    }

    public Float operation(Float number1, Float number2, char op) {
        switch (op) {
            case '+': {
                return number1 + number2;
            }
            case '-': {
                return number1 - number2;
            }
            case '/': {
                return number1 / number2;
            }
            case '*': {
                return number1 * number2;
            }
            default:
                throw new RuntimeException("ERROR: OPERATION IS NOT ALLOWED");

        }
    }
}
