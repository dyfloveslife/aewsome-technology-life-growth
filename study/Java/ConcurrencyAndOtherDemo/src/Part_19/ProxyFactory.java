package Part_19;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 代理对象
public class ProxyFactory {

    // 维护目标对象
    private Object target;

    // 当创建对象的时候就对 target 进行初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 生成一个代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK 动态代理...");
                        // 利用反射机制调用目标对象的方法
                        Object invoke = method.invoke(target, args);
                        return invoke;
                    }
                });
    }
}
