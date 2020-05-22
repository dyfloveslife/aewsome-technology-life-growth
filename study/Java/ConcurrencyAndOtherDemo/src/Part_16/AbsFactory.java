package Part_16;

// 抽象模式的接口层
public interface AbsFactory {

    // 让工厂子类去具体实现
    Pizza createPizza(String orderType);
}
