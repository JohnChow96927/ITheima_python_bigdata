package d_if_switch_for;

public class Demo7_For {
    public static void main(String[] args) {
        /*
            Ŀ��: ��� 1 ~ 100
            ��ʽ:
                for(���ʽ1; ���ʽ2; ���ʽ4) {
                    ���ʽ3 ... ...;
                }
            ����:
                ���ʽ1
               ��� ���ʽ2 �Ľ�� Ϊ true, ��ȥִ�� ���ʽ3,
               ִ�б��ʽ4

               ��� ���ʽ2 �Ľ�� Ϊ true, ��ȥִ�� ���ʽ3,
               ִ�б��ʽ4

               ����������: ���ʽ2�Ľ��Ϊfalse

         */
        for (int i = 1; i <= 100; i++){
            System.out.println(i);
        }
    }
}
