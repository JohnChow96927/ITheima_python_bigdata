package d_random_number;

import java.util.Scanner;

public class Demo1_Random {
    public static void main(String[] args) {
        // ����: ��һ��������
        Scanner scanner = new Scanner(System.in);
        System.out.print("������ѧ������(>0): ");
        int stu_count = scanner.nextInt();
        int num = (int) (Math.random() * stu_count + 1);
        System.out.println("���㵽����ѧ��ѧ��Ϊ: " + num);

        // ��ҵ: ������10�� 50-100����������
        int n = 1;
        while (n <= 10) {
            System.out.printf("���ɵĵ�" + n + "��50-100����������Ϊ: " + (int) (Math.random() * 51 + 50) + "\n");
            n++;
        }
    }
}
