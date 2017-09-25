import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import proxy.AnimalFactory;
import proxy.DogImp;
import proxy.imp.AOPMethod;
import proxy.imp.AnimalInterface;

import java.lang.reflect.Method;

@RunWith(BlockJUnit4ClassRunner.class)
public class AOPTest {

	public static void main(String[] args) {

		AnimalInterface dog = AnimalFactory.getAnimal( DogImp.class, new AOPMethod() {
			// ����д����ִ��ǰ��AOP���뷽��
			public void before(Object proxy, Method method, Object[] args) {
				if (method.getName().equals("getProperty")) {
					System.err.println("�ɹ�����" + method.getName() + "����,����");
				}
			}

			// ����ϵ����ִ�к��AOP���뷽��
			public void after(Object proxy, Method method, Object[] args) {
				if (method.getName().equals("getProperty"))
					System.err.println("�ɹ�����" + method.getName() + "����,����");

			}
		});
		dog.bark();
		String name = "�����������" + dog.getName();
		System.out.println(name);
		dog.setName("������");
		name = "�ҵ�������" + dog.getName();
		System.out.println(name);
		dog.getProperty();
		dog.eating();
	}
}
