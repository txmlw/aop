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
			// 这里写方法执行前的AOP切入方法
			public void before(Object proxy, Method method, Object[] args) {
				if (method.getName().equals("getProperty")) {
					System.err.println("成功拦截" + method.getName() + "方法,启动");
				}
			}

			// 这里系方法执行后的AOP切入方法
			public void after(Object proxy, Method method, Object[] args) {
				if (method.getName().equals("getProperty"))
					System.err.println("成功拦截" + method.getName() + "方法,结束");

			}
		});
		dog.bark();
		String name = "动物的名字是" + dog.getName();
		System.out.println(name);
		dog.setName("二狗子");
		name = "我的名字是" + dog.getName();
		System.out.println(name);
		dog.getProperty();
		dog.eating();
	}
}
