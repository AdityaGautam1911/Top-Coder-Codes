//inheritance
public class test {
    public static class Shape {
        public void area() {
            System.out.println("Displaying the area");
        }
    }

    // single level inheritance
    public static class Triangle extends Shape {
        public void area(int b, int ht) {
            System.out.println("Area of the triangle is : " + 0.5 * b * ht);
        }
    }

    // hierarchial inheritance
    public static class Circle extends Shape {
        public void area(int r) {
            System.out.println("Area of the circle is : " + 3.14 * r * r);
        }
    }

    // multilevel inheritance
    public static class EquilateralTriangle extends Triangle {
        public void area(int b, int ht) {
            System.out.println("Area of equi. triangle : " + 0.5 * b * ht);
        }
    }

    public static void main(String[] args) {
        EquilateralTriangle et = new EquilateralTriangle();
        et.area(2, 4);

    }
}