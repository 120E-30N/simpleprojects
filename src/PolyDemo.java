public class PolyDemo {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.count);  // 20
        sub.display();  // 20

        Base base = sub;
        System.out.println(base == sub);  // true --> 两个引用指向同一个对象
        System.out.println(base.count);  // 10 --> 编译类型：Base
        base.display();  // 20 --> 运行类型：Sub
    }
}

class Base {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;

    public void display() {
        System.out.println(this.count);
    }
}