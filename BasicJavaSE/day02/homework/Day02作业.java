1. ��֪��è��͹���, ���Ƕ�������������, ��Ҫ�Է�, ��ͬ����è����, ������. 
   ���Ƕ����ܲ��Ĺ���, ���ҽ������ܲ�, �����κ�����. 
   è�����Լ��Ĺ���: ץ����catchMouse(), �������Լ��Ĺ���: ����lookHome()
   ���ֵ�è�͹�������Ϸ�ŵ�ѵ����, ѧ��������jump(), ������ѧ, ģ���֪ʶ.
   
   public abstract class Animal {
	   //����
	   private String name;
	   private int age;
	   
	   //���췽��, �ղ�, ȫ��.
	   
	   //getXxx(), setXxx()
	   
	   //��Ϊ
	   public abstract void eat();   //���󷽷�, ǿ��Ҫ������������ĳЩ�¶�.
	   
	   public void run() {			 //�ǳ��󷽷�, ������̳�, ��ߴ���ĸ�����.
		   sop("�������"); 
	   }
   }
   
   public class Cat extends Animal{
	   //���췽��, �ӿ� -> ����, ��ȫ -> ��ȫ
	   
	   //è�����Լ��Ĺ���: ץ����catchMouse()
	   public void catchMouse() {
		   sop("ץ����");
	   }
	   
	   //��дAnimal���eat()
   }
   
   public interface Jumping{
	   void jump();
   }
   
   public class JumpCat extends Cat implements  Jumping {   //����è
		//���췽��, �ӿ� -> ����, ��ȫ -> ��ȫ
		
		//��дJumping�ӿڵ�jump()
   }
   
   
   Jumping jm = new JumpCat();
   Jumping jm = new JumpDog();  //�ӿڶ�̬.
   
   
   public static void printJump(Jumping jm) {	//Jumping jm = new JumpCat()
	   jm.jump();
   }
   
   //��������: ������(�����̳���ϵ�� ��������), �ӿ�(�����̳���ϵ�� ��չ����)
   
   
2. ��֪��ƹ�����˶�Ա(PingPangPlayer)�������˶�Ա(BasketballPlayer), ƹ�������(PingPangCoach)���������(BasketballCoach). 
   ���Ƕ�������������, ��Ҫ�Է�, ���ǳԵĶ�����ͬ. 
   ƹ�����������η���, �����������������Ͷ��.
   ƹ�����˶�Աѧϰ��η���, �����˶�Աѧϰ��������Ͷ��. 
   Ϊ�˳�������, ��ƹ������ص���Ա����ҪѧϰӢ��. 
   ������ѧ, ģ���֪ʶ. 
   
   
3. ��֪���ǲ��͹�˾�л�������ʦ(BasicTeacher)�;�ҵ����ʦ(WorkTeacher), ������ѧ��(BasicStudent)�;�ҵ��ѧ��(WorkStudent).
   ���Ƕ�������, ����, ��Ҫ�Է�, ��ͬ����ѧ����ţ��, ��ʦ��ţ����. 
   ��ʦ���Լ��Ķ�������: ����(salary), ����ʦ��Ҫ����(��������ʦ��JavaSE, ��ҵ����ʦ��JavaEE, Hadoop, Hive, Scala, Flink, Spark��).   
   ������ѧ��ѧϰJavaSE, ��ҵ��ѧ��ѧϰJavaEE, Hadoop, Hive, Scala, Flink, Spark��.
   Ϊ�������ҵ�г�, ����ҵ����ص���Ա����ҪѧϰӢ��. 
   ������ѧ, ģ���֪ʶ. 