package com.example.calculator;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("\n 계산을 수행합니다.");

            // 첫 번째 양의 정수 입력
            int firstNumber = getPositiveInt(scanner);

            // 두 번째 양의 정수 입력
            int secondNumber = getPositiveInt(scanner);

            // 연산자 입력
            int operatorSymbol = getOperatorSymbol(scanner);

            //연산 수행
            int result = calculator.calculate(firstNumber, secondNumber, operatorSymbol);
            calculator.addResult(result); // 세터 메서드 수행(간접 접근을 통해 필드에 접근하여 수정)
            if (result != Integer.MIN_VALUE) {
                System.out.println("연산 결과 : " + result);
            }

            // 연산 이력 확인
            while (true) {
                System.out.print("\n 연산 이력을 확인하시겠습니까? (Y/N): ");
                String historyInput = scanner.nextLine();

                if (historyInput.equalsIgnoreCase("y")) { // 대소문자 구분 없이 비교
                    List<Integer> history = calculator.getResults(); // 게터 메서드 수행(간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현)
                    System.out.println(" 연산 이력: " + history);
                    break; // 연산 이력을 확인했으므로 반복문 종료
                } else if (historyInput.equalsIgnoreCase("n")) { // 'N' 또는 'n' 입력 시 건너뛰기
                    break; // 'N' 또는 'n'을 입력하면 실행 여부 확인으로 진행
                } else {
                    System.out.println(" 잘못된 입력입니다. 'Y' 또는 'N'을 입력하세요.");
                }
            }


            //실행 여부 확인
            System.out.print("\n 계속 이용하려면 아무 키나 입력하세요, 종료하려면 'exit' 입력: ");
            String exit = scanner.nextLine(); //사용자 입력 받기
            // 대소문자 상관없이 exit 이 입력되면
            if (exit.equalsIgnoreCase("exit")) {
                break; // 종료
            }
        }

        System.out.println("계산을 종료합니다.");
        scanner.close();


    }
        // 양의 정수를 입력받는 메서드
        public static int getPositiveInt(Scanner scanner){
        while (true) {
            System.out.print("첫 번째 양의 정수를 입력하세요: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine(); //개행 문자 제거
                if (number >= 0) {
                    return number;
                } else {
                    System.out.println("양의 정수를 입력해야 합니다. 다시 입력하세요.");
                }
            } else {
                System.out.println("숫자가 아닙니다. 다시 입력하세요.");
                scanner.next(); // 잘못된 입력 제거
            }
        }
    }

        // 연산자 선택 받기
    public static int getOperatorSymbol(Scanner scanner) {
        while (true) {
            System.out.print("사칙연산 기호의 숫자를 선택하세요 (1.더하기 2.빼기 3.곱하기 4.나누기): ");
            if (scanner.hasNextInt()) {
                int operator = scanner.nextInt();
                scanner.nextLine();
                if (operator >= 1 && operator <= 4) {
                    return operator;
                } else {
                    System.out.println("1에서 4의 숫자를 입력해야 합니다. 다시 입력하세요.");
                }
            } else {
                System.out.println("숫자가 아닙니다. 다시 입력하세요.");
                scanner.next(); // 잘못된 입력 제거
            }
        }
    }

//        // 연산 수행
//    public static int calculateOperate(int firstNumber, int secondNumber, int operatorSymbol) {
//        int result = 0;
//        switch (operatorSymbol) {
//            case 1:
//                result = firstNumber + secondNumber;
//                System.out.println("덧셈 결과: " + result);
//                break;
//            case 2:
//                result = firstNumber - secondNumber;
//                System.out.println("뺄셈 결과: " + result);
//                break;
//            case 3:
//                result = firstNumber * secondNumber;
//                System.out.println("곱셈 결과: " + result);
//                break;
//            case 4:
//                if (secondNumber == 0) {
//                    System.out.println("0으로 나눌 수 없습니다!");
//                    return Integer.MIN_VALUE;
//                } else {
//                    result = firstNumber / secondNumber;
//                    System.out.println("나눗셈 결과: " + result);
//                }
//                break;
//            default:
//                System.out.println("올바른 연산자를 입력하세요.");
//                return Integer.MIN_VALUE;
//        }
//        return result;
//    }
}

