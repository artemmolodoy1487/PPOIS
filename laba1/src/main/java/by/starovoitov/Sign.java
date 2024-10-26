package by.starovoitov;

public enum Sign {

    PLUS('+'),
    MINUS('-');

    private final char symbol;

    Sign(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public int getValue() {
        return switch (this) {
            case PLUS -> 1;
            case MINUS -> -1;
        };
    }


}