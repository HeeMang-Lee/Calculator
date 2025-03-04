package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    // 속성
    private final List<Double> results;

    // 생성자
    public ArithmeticCalculator() {
        this.results = new ArrayList<>();
    }

    // 기능
    public <T extends Number> calculate(T firstNumber,T secondNumber,OperatorType operator) {
        double result = operator.apply(firstNumber,secondNumber);
        return result;
    }

    // 게터 기능 활용 : 연산 기록 조회
    public List<Double> getResults(){
        return results;
    }

    // 세터 기능 활용 : 연산 결과 저장
    public void addResults(double result){
        this.results.add(result);
    }

    // 저장된 연산 기록 삭제 (FIFO)
    public void removeResults(){
        if (!results.isEmpty()){ // 빈 리스트 예외 방지
            results.remove(0); // 가장 먼저 등록된 연산 결과 삭제
        }
    }


}
