package c_nested_loop;

public class Demo1 {
    public static void main(String[] args) {
        // ����: ���2020 ~ 2025����·�, �����ʽ: yyyy��MM��
        for (int i = 2020; i < 2026 ; i++) {
            for (int j = 1; j < 13; j++) {
                String month = String.format("%02d", j);
                System.out.println(i + "��" + month + "��");
            }
        }
    }
}
