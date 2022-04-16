package d_if_switch_for;

import java.util.Scanner;

public class Demo6_Switch {
    public static void main(String[] args) {
        /*
            1.һ����12����, �����ڴ����ﶬ4������, ����¼��һ���·�, ���ó���ʵ���жϸ��·������ĸ�����, �������
            2.�����׼����:
                1.���룺 1��2��12 ���������
                2.���룺 3��4��5 ���������
                3.���룺 6��7��8 ������ļ�
                4.���룺 9��10��11 ������＾
                �C���룺�������� �������������
         */
        // 1 ��ȡ�û�������·�
        // 1.1 ��������
        Scanner scanner = new Scanner(System.in);
        // 1.2 ͨ�������ȡ�û������ֵ
        System.out.println("�������Ӧ���·�: ");
        int month = scanner.nextInt();
        // 1.3 ��ӡ����
        //System.out.println(month);

        // 2 �����û�������·� ��ӡ ��Ӧ�ļ���
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("����");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("����");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("�ļ�");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("�＾");
                break;
            default:
                System.out.println("��������ȷ���·�!");
                break;
        }
    }
}
