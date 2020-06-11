package Part_22;

public abstract class Drink {

    public String des;
    private float price = 0.0F;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // 计算费用的方法
    // 由具体的子类实现
    public abstract float cost();
}
