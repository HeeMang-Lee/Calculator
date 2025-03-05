package com.example.calculator;

/** 연산자(Enum) 타입을 정의하는 클래스
 * 연산 기호('+','-','*','/')를 상수로 관리
 * 각 연산자에 대한 계산 로직을 직접 정의 (apply 메서드 오버라이딩)
*/
public enum OperatorType {
    // 덧셈 연산
    ADD("+"){
        @Override
        public <T extends Number> double apply(T a, T b){
            return a.doubleValue()+b.doubleValue();
        }
    },
    // 뺄셈 연산
    SUBTRACT("-"){
        @Override
        public <T extends Number> double apply(T a, T b){
            return a.doubleValue() - b.doubleValue();
        }
    },
    // 곱셈 연산
    MULTIPLY("*"){
        @Override
        public <T extends Number> double apply(T a, T b){
            return a.doubleValue() * b.doubleValue();
        }
    },
    // 나눗셈 연산 , 0으로 나누는 경우 'ArithmeticException' 발생
    DIVIDE("/"){
        @Override
        public <T extends Number> double apply(T a, T b){
            if (b.doubleValue() == 0){
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a.doubleValue() / b.doubleValue();
        }
    };

    // 연산자 기호를 저장하는 필드
    private final String symbol;

    // 연산자 Enum 생성자
    OperatorType(String symbol){
        this.symbol = symbol;
    }

    // 두 숫자를 연산하는 추상 메서드
    public abstract <T extends Number> double apply (T a, T b);

    // 입력된 문자열을 기반으로 해당하는 연산자 타입 반환, 입력된 연산자가 존재하지 않으면 예외 발생
    public static OperatorType parseOperator(String input) {
        for (OperatorType op : values()) {
            if (op.symbol.equals(input)) {
                return op;
            }
        }
        throw new IllegalArgumentException("올바른 연산자를 입력하세요.");
    }
}
