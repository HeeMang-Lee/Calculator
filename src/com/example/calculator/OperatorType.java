package com.example.calculator;

public enum OperatorType {
    ADD("+"){
        @Override
        public <T extends Number> apply(T a, T b){
            return a.doubleValue()+b.doubleValue();
        }
    },
    SUBTRACT("-"){
        @Override
        public <T extends Number> apply(T a, T b){
            return a.doubleValue() - b.doubleValue();
        }
    },
    MULTIPLY("*"){
        @Override
        public <T extends Number> apply(T a, T b){
            return a.doubleValue() * b.doubleValue();
        }
    },
    DIVIDE("/"){
        @Override
        public <T extends Number> apply(T a, T b){
            if (b.doubleValue() == 0){
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a.doubleValue() / b.doubleValue();
        }
    };

    private final String symbol;

    OperatorType(String symbol){
        this.symbol = symbol;
    }
    public abstract <T extends Number> double apply (T a, T b);

    public static OperatorType parseOperator(String input) {
        for (OperatorType op : values()) {
            if (op.symbol.equals(input)) {
                return op;
            }
        }
        throw new IllegalArgumentException("올바른 연산자를 입력하세요.");
    }
}
