package d_if_switch_for;

import java.util.Scanner;

public class Demo3_If_Double_Branch {
    public static void main(String[] args) {
        /*
            1.��ʾ�û�����¼��һ�����ݲ�����.
            2.�жϸ���������������ż��, ���������ӡ������̨��.
         */
        // 1.��ʾ�û�����¼��һ�����ݲ�����.
        // 1.1 �������� Scanner
        Scanner scanner = new Scanner(System.in);
        // 1.2 ��ȡ�û������ֵ
        System.out.println("������һ������: ");
        int num = scanner.nextInt();
        // 1.3 ��ӡ����
        System.out.println("�����������: " + num);

        // 2.�жϸ���������������ż��, ���������ӡ������̨��.
        if (num % 2 == 0) {
            System.out.println(num + "�� ż��!");
        } else {
            System.out.println(num + "�� ����!");
        }
    }
}
