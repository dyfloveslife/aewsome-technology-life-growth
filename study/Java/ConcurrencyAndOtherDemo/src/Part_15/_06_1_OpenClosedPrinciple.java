package Part_15;

public class _06_1_OpenClosedPrinciple {
    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(new Rectangle());
        editor.drawShape(new Circle());

        editor.drawShape(new Triangle());
    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
       s.draw();
    }
}

abstract class Shape {
    int type;

    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle extends Shape {
    Circle() {
        type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Triangle extends Shape {
    Triangle() {
        type = 3;
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}