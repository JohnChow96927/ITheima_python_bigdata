package d_if_switch_for;

public class Demo8_For_2 {
    public static void main(String[] args) {
        // ���� ��1-100֮���ż����, ������ͽ����ӡ������̨
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
