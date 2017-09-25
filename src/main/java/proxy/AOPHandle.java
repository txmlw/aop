package proxy;

import proxy.imp.AOPMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AOPHandle implements InvocationHandler {
	//�������
	private AOPMethod method;
	private Object object;
	public AOPHandle(Object obj, AOPMethod method) {
		this.object=obj;
		this.method=method;
	}
	/**
	 * ����������Զ�����,Java��̬�������
	 * �ᴫ�������Ǹ�����
	 * @param  proxy	�������Ľӿ�,��ͬ�ڶ���
	 * @param  method	�����÷���
	 * @param  args	��������
	 * ����ʹ��invokeʱʹ��proxy��Ϊ�������ʱ,��Ϊ�������Ľӿ�,��ͬ�ڶ���
	 * ���ִ������������ӿڣ��������������
	 **/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret=null;
		//����ִ��ǰ���ӵ���
		this.method.before(proxy, method, args);
		ret=method.invoke(object, args);
		//����ִ�к����ӵ���
		this.method.after(proxy, method, args);
		return ret;
	}
}
