package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber; // 첫 번째 입력 받을 양의 정수
        int secondNumber; // 두 번째 입력 받을 양의 정수
        int result = 0; // 초기화 필수
        int operatorSymbol;

        // 첫 번째 양의 정수 입력 받기
        while (true) {
            System.out.print("첫 번째 양의 정수를 입력하세요: ");
            if (scanner.hasNextInt()) {
                firstNumber = scanner.nextInt();
                if (firstNumber > 0) {
                    break;
                } else {
                    System.out.println("양의 정수를 입력해야 합니다. 다시 입력하세요.");
                }
            } else {
                System.out.println("숫자가 아닙니다. 다시 입력하세요.");
                scanner.next(); // 잘못된 입력 제거
            }
        }

        // 두 번째 양의 정수 입력 받기
        while (true) {
            System.out.print("두 번째 양의 정수를 입력하세요: ");
            if (scanner.hasNextInt()) {
                secondNumber = scanner.nextInt();
                if (secondNumber > 0) {
                    break;
                } else {
                    System.out.println("양의 정수를 입력해야 합니다. 다시 입력하세요.");
                }
            } else {
                System.out.println("숫자가 아닙니다. 다시 입력하세요.");
                scanner.next(); // 잘못된 입력 제거
            }
        }

        // 연산자 선택 받기
        while (true) {
            System.out.print("사칙연산 기호의 숫자를 선택하세요 (1.더하기 2.빼기 3.곱하기 4.나누기): ");
            if (scanner.hasNextInt()) {
                operatorSymbol = scanner.nextInt();
                if (operatorSymbol >= 1 && operatorSymbol <= 4) {
                    break;
                } else {
                    System.out.println("1에서 4의 숫자를 입력해야 합니다. 다시 입력하세요.");
                }
            } else {
                System.out.println("숫자가 아닙니다. 다시 입력하세요.");
                scanner.next(); // 잘못된 입력 제거
            }
        }

        // 연산 수행
        switch (operatorSymbol) {
            case 1:
                result = firstNumber + secondNumber;
                System.out.println("덧셈 결과: " + result);
                break;
            case 2:
                result = firstNumber - secondNumber;
                System.out.println("뺄셈 결과: " + result);
                break;
            case 3:
                result = firstNumber * secondNumber;
                System.out.println("✖곱셈 결과: " + result);
                break;
            case 4:
                if (secondNumber == 0) {
                    System.out.println("0으로 나눌 수 없습니다!");
                } else {
                    result = firstNumber / secondNumber;
                    System.out.println("나눗셈 결과: " + result);
                }
                break;
            default:
                System.out.println("올바른 연산자를 입력하세요.");
        }

        scanner.close();
    }
}
