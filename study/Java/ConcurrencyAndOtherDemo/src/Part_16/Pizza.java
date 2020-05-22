package Part_16;

public abstract class Pizza {
    public String name;

    public abstract void prepare();

    public void back() {
        System.out.println(name + " backing...");
    }

    public void cut() {
        System.out.println(name + " cutting...");
    }

    public void box() {
        System.out.println(name + " boxing...");
    }

    public void setName(String name) {
        this.name = name;
    }
}
