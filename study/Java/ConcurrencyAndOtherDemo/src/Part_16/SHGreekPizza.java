package Part_16;

public class SHGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("上海的 GreekPizza...");
        System.out.println("给 SHGreekPizza 准备原材料...");
    }
}
