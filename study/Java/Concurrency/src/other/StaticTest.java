package other;

 class StaticFieldTest {

    public static int i;
    public int j;

    StaticFieldTest(int j) {
        this.j = j;
    }

    public static void main(String[] args) {
        System.out.println(StaticFieldTest.i);
    }
}
