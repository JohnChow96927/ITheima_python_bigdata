package a_keyword;

public class Demo6_Variable_4 {
    public static void main(String[] args) {
        // Ŀ��1: ������С���� Ĭ������
        int i1 = 20;
        double d = 3.14;

        // Ŀ��2: ������������������
        // ע��: ��ֵ��ʱ��, ��Ҫ������Χ
        byte b1 = 10;
        // byte b2 = 130; // ����ԭ��: byte�ķ�Χ -128 ~ 127, �����������Χ

        short s1 = 1000;
        //short s2 = 300000;

        // Ŀ��3: ��С���͵�ֵ �ŵ� ��������, ֱ�ӷžͿ���
        long l1 = 10000;
        long l2 = 20000L;
        long l3 = 20000L;

        // Ŀ��4: ���������е�ֵ �ŵ� С������, ��Ҫǿ������ת��
        int i2 = (int) l1;

        // ����ԭ��: 3.14��double����, ��float����
        //float f1 = 3.14;

        // ���1:
        float f2 = (float) 3.14;
        System.out.println(f2);

        // ���2:
        float f3 = 3.14F;
    }
}
