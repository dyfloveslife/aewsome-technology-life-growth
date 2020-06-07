package Part_19;

public class Client {
    public static void main(String[] args) {
        // 首先创建目标对象
        TeacherDao target = new TeacherDao();

        // 然后创建代理对象
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        System.out.println(proxyInstance.getClass());

        // 通过代理对象调用目标对象的方法
        proxyInstance.teach();
    }
}
