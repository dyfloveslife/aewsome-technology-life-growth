package Part_18;

// 静态代理演示：此类为代理对象
public class TeacherDAOProxy implements ITeacherDAO {

    private ITeacherDAO target;

    public TeacherDAOProxy(ITeacherDAO target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理...");
        target.teach();
        System.out.println("代理结束...");
    }
}
