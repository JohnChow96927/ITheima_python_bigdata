package b_dead_loop;

public class Demo3_Break_Continue {
    public static void main(String[] args) {
        // ����: ���1 ~ 100, ��7�ı�������, ��90��ʱ��ֹͣѭ��
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                continue;
            }
            if (i == 90) {
                break;
            }
            System.out.println(i);
        }
    }
}
