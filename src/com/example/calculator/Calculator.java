package com.example.calculator;

import java.util.List;
import java.util.ArrayList;

public class Calculator {
    // 속성
    private List<Integer> results; // 연산 결과를 저장하는 컬렉션 타입 리스트 생성

    // 생성자
    public Calculator() {
        this.results = new ArrayList<>();
    }

    // 기능
    public int calculate(int firstNumber, int secondNumber, int operatorSymbol) {
        int result = 0;
        switch (operatorSymbol) {
            case 1:
                result = firstNumber + secondNumber;
                break;
            case 2:
                result = firstNumber - secondNumber;
                break;
            case 3:
                result = firstNumber * secondNumber;
                break;
            case 4:
                if (secondNumber == 0){
                    System.out.println("0으로 나눌 수 없습니다.");
                    return Integer.MIN_VALUE;
                }
                result = firstNumber / secondNumber;
                break;
            default:
                System.out.println("올바른 연산자를 입력하세요");
                return Integer.MIN_VALUE;
        }
        return result;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void addResult(int result) {
        this.results.add(result);
    }
}
