package Part_18;

public class Client {
    public static void main(String[] args) {
        // 首先创建目标对象
        TeacherDAO teacherDAO = new TeacherDAO();

        // 然后创建代理对象，同时将目标对象传递给代理对象
        TeacherDAOProxy teacherDAOProxy = new TeacherDAOProxy(teacherDAO);

        // 通过代理对象，执行目标对象的方法
        // 即执行的是代理对象的方法，代理对象再去调用目标对象的方法
        teacherDAOProxy.teach();
    }
}
