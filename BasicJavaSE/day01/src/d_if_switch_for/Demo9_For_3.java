package d_if_switch_for;

public class Demo9_For_3 {
    public static void main(String[] args) {
        int num = 10 / 3;
        System.out.println(num);

        /*
        ˮ�ɻ���
            1.ˮ�ɻ�����һ��3λ��������. [100, 999]
            2.�����ֵĸ���λ����������ӵ���������. ��ȡ��������ĸ�λ ʮλ ��λ
            3.����: 153����ˮ�ɻ���, 153 = 1 * 1 * 1 + 5 * 5 * 5 + 3 * 3 * 3 = 153
         */
        for (int i = 100; i <= 999; i++) {
            int index_3 = i / 1 % 10;
            int index_2 = i / 10 % 10;
            int index_1 = i / 100 % 10;
            if ((index_1 * index_1 * index_1 + index_2 * index_2 * index_2 + index_3 * index_3 * index_3) == i) {
                System.out.println(i);
            }
        }
    }
}
