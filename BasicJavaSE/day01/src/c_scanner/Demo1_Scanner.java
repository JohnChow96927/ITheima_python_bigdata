package c_scanner;

import java.util.Scanner;

public class Demo1_Scanner {
    public static void main(String[] args) {
        // 1. ��ȡScanner����
        Scanner scanner = new Scanner(System.in);

        // 2. ���÷�����ȡ�û������ֵ
        System.out.println("��������������: ");
        String age = scanner.next();

        System.out.println("����������: " + age);

        // ����: ��ȡ�������е����, ����͵����
        // 1. ����Scanner����
        Scanner scanner2 = new Scanner(System.in);
        // 2. ��ȡ�������е����
        System.out.println("�������һ�����е����:");

        int height1 = scanner.nextInt();

        System.out.println("������ڶ������е����:");
        int height2 = scanner.nextInt();

        System.out.println("��������������е����:");
        int height3 = scanner.nextInt();

        // 3. ����͵����
        // ��ʽһ
        // int min = height1 < height2 ? height1 : height2;
        // int min2 = min < height3 ? min : height3;

        // ��ʽ��
        // int min = height1 < height2 ? height1 : height2;
        // min = min < height3 ? min : height3;

        // ��ʽ��
        int min = (height1 < height2 ? height1 : height2) < height3 ? (height1 < height2 ? height1 : height2) : height3;

        // 4 ��ӡ
        System.out.println("����: " + min);
    }
}
