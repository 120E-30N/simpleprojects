public class PolyDynamic {
    /**
     * 动态绑定机制
     * 	1. 当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定
     * 	2. 当调用对象的属性时，没有动态绑定机制，哪里声明，哪里使用
     */
    public static void main(String[] args) {
        // 编译类型A 运行类型B
        A a = new B();
        /*
            A 中的 sum() -> B 中的 getI() -> B 中的 i
            1. B类没有sum方法，B类的父类A中有sum方法 --> 调用A的sum()方法
            2. A类的sum方法中调用了getI方法，而对象a的运行类型是B所以动态绑定机制会先回到B类寻找getI方法，
                B类中存在getI方法，则调用B类中的getI方法
            3. getI方法返回i值，即调用了属性，属性没有动态绑定机制，在哪里声明 就在哪里使用，所以返回B类的i
         */
        System.out.println(a.sum());  // 30
        System.out.println(a.sum1());  // 20
    }
}

class A {
    public int i = 10;

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A {
    public int i = 20;

//    public int sum() {
//        return getI() + 10;
//    }

//    public int sum1() {
//        return i + 10;
//    }

    public int getI() {
        return i;
    }
}
