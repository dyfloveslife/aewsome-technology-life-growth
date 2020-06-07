package Part_20;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    // 维护一个目标对象
    private Object target;

    // 传入被代理的对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回一个代理对象
    public Object getProxyInstance() {
        // 创建工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类对象，即代理对象
        return enhancer.create();
    }

    // 重写 intercept 方法，将会调用目标对象中的方法
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGlib 代理开始...");
        Object res = method.invoke(target, args);
        System.out.println("CGlib 代理结束...");
        return res;
    }
}
