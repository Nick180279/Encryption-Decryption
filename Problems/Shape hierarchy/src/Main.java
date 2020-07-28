abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Circle extends Shape {
    double radius;

    public Circle (double r) {
        radius = r;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double height;
    double width;

    public Rectangle (double h, double w) {
        height = h;
        width = w;
    }

    @Override
    double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    double getArea() {
        return height * width;
    }
}

class Triangle extends Shape {
    double a;
    double b;
    double c;

    public Triangle (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}