package Part_19;

// 目标对象
public class TeacherDao implements ITeacherDao{

    @Override
    public void teach() {
        System.out.println("正在授课...");
    }
}
