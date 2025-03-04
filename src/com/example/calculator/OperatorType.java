package com.example.calculator;

public enum OperatorType {
    ADD("+"){
        @Override
        public int apply(int a, int b){
            return a+b;
        }
    },
    SUBTRACT("-"){
        @Override
        public int apply(int a, int b){
            return a - b;
        }
    },
    DIVIDE("/"){
        @Override
        public int apply(int a, int b){
            if (b == 0){
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
    };

    private final String symbol;

    OperatorType(String symbol){
        this.symbol = symbol;
    }
    public abstract int apply(int a, int b);

    public static OperatorType parseOperator(String input) {
        for (OperatorType op : values()) {
            if (op.symbol.equals(input)) {
                return op;
            }
        }
        throw new IllegalArgumentException("올바른 연산자를 입력하세요.");
    }
}
