package d_random_number;

import java.util.Scanner;

public class Demo2_Guess_Number {
    public static void main(String[] args) {
        int answer = (int) (Math.random() * 100 + 1);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("��������Ҫ�µ���: ");
            int guess = scanner.nextInt();
            if (guess > answer) {
                System.out.println("����, �����!");
            } else if (guess < answer) {
                System.out.println("С��, �����!");
            } else {
                System.out.println("��ϲ���¶���, �𰸾���" + answer + "!");
                break;
            }

        }
    }
}
