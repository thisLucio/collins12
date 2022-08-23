package Stely.Domain;

import Stely.Domain.Support.TokenType;

public class Token {
    private TokenType type;
    private String value;

    public Token(TokenType type) {
        this.type = type;
        this.value = null;
    }

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }
    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
