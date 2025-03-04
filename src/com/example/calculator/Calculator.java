package com.example.calculator;

import java.util.List;
import java.util.ArrayList;

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

    public static OperatorType parseOperator(String input){
        for (OperatorType op : values()){
            if(op.symbol.equals(input)){
                return op;
            }
        }
    }
    throw new IllegalArgumentException("올바른 연산자를 입력하세요.")
}

//public class Calculator {
//    // 속성
//    private List<Integer> results; // 연산 결과를 저장하는 컬렉션 타입 리스트 생성
//
//    // 생성자
//    public Calculator() {
//        this.results = new ArrayList<>();
//    }
//
//    // 기능
//    public int calculate(int firstNumber, int secondNumber, int operatorSymbol) {
//        int result = 0;
//        switch (operatorSymbol) {
//            case 1:
//                result = firstNumber + secondNumber;
//                break;
//            case 2:
//                result = firstNumber - secondNumber;
//                break;
//            case 3:
//                result = firstNumber * secondNumber;
//                break;
//            case 4:
//                if (secondNumber == 0){
//                    System.out.println("0으로 나눌 수 없습니다.");
//                    return Integer.MIN_VALUE;
//                }
//                result = firstNumber / secondNumber;
//                break;
//            default:
//                System.out.println("올바른 연산자를 입력하세요");
//                return Integer.MIN_VALUE;
//        }
//        return result;
//    }

    public List<Integer> getResults() {
        return results;
    }

    public void addResult(int result) {
        this.results.add(result);
    }

    public void removeResult() {
        if(!results.isEmpty()) {
            results.remove(0);
        }
    }

