package Stely.Lexer;

import Stely.Domain.Support.TokenType;
import Stely.Domain.Token;
import Stely.Exceptions.LexerException;

import java.util.Arrays;

public class Lexer {
    private final String code_input;
    private final int code_length;

    private int code_index;

    private Token currentToken;
    private Token previousToken;


    public Lexer(String code_input) {
        this.code_input = code_input;
        this.code_length = code_input.length();
        this.code_index = 0;
    }

    public boolean nextToken(){


        while(!isEndOfCode()){
            previousToken = currentToken;
             final char currentChar = code_input.charAt(code_index);

             if(Arrays.asList(' ', '\r', '\t', '\n').contains(currentChar)){
                 skipWhiteSpace();
                 continue;
             } else if (currentChar == '=') {
                 currentToken = new Token(TokenType.EQUALS_OPERATOR);
                 code_index++;
             } else if (Character.isDigit(currentChar)) {
                 currentToken = new Token(TokenType.NUMBER, readNumber());
                 code_index++;
             } else if (Character.isLetter(currentChar)) {
                 String variableName = readVariable();
                 if(variableName.equalsIgnoreCase("output")){
                     currentToken = new Token(TokenType.OUTPUT);
                 }
                 else{
                     currentToken = new Token(TokenType.VARIABLE, variableName);
                 }
             }else{
                 throw new LexerException("Stely ERROR: TOKEN IS NOT DEFINED.");
             }
             return true;
        }
        return false;
    }
    private String readNumber() {
        StringBuilder sb = new StringBuilder();
        char currentChar = code_input.charAt(code_index);
        while (!isEndOfCode() && Character.isDigit(currentChar)) {
            sb.append(currentChar);
            code_index++;
            if (isEndOfCode()) break;
            currentChar = code_input.charAt(code_index);
        }
        return sb.toString();
    }


    private String readVariable() {
        StringBuilder sb = new StringBuilder();
        char currentChar = code_input.charAt(code_index);
        while (!isEndOfCode() && Character.isLetter(currentChar)) {
            sb.append(currentChar);
            code_index++;
            if (isEndOfCode()) break;
            currentChar = code_input.charAt(code_index);
        }
        return sb.toString();
    }
    private void skipWhiteSpace() {
        while (!isEndOfCode()) {
            if (Arrays.asList(' ', '\r', '\t', '\n').contains(code_input.charAt(code_index))) {
                code_index++;
            } else {
                break;
            }
        }
    }
    private boolean isEndOfCode() {
        return code_index >= code_length;
    }

    public Token getPreviousToken(){
        return previousToken;
    }
    public Token getCurrentToken(){
        return currentToken;
    }

}
