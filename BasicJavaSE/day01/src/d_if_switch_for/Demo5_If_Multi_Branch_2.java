package d_if_switch_for;

import java.util.Scanner;

public class Demo5_If_Multi_Branch_2 {
    public static void main(String[] args) {
        /*
            1.С����Ҫ��ĩ�����ˣ�С���ְֶ���˵����������Ŀ��Գɼ���������ͬ������.
            2.��������Կ���С���ĵ÷֣����ó���ʵ��С�����׸û��ʲô����������ڿ���̨�����
            3.�����׼����:
                �C95~100 ɽ�����г�һ��
                �C90~94 ���ֳ���һ��
                �C80~89 ���ν�����һ��
                �C80���� ����һ��
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("������С���ĳɼ�: ");
        int score = scanner.nextInt();

        if (score >= 0 && score <= 100) {
            if (score >= 95) {
                System.out.println("1. ���� ɽ�����г�һ��");
            } else if (score >= 90) {
                System.out.println("2. ���� ���ֳ���һ��");
            } else if (score >= 80) {
                System.out.println("3. ���� ���ν�����һ��");
            } else {
                System.out.println("4. �ͷ� ����һ��");
            }
        } else {
            System.out.println("��������ȷ�ķ��� [0 ~ 100]!");
        }
    }
}
