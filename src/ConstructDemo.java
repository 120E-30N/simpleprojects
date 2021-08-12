/**
 * 构造器的复用，构造器在继承中的调用规则
 */
public class ConstructDemo {

  public static void main(String[] args) {
    Employee employee = new Employee();
  }
}

class People {
    public People() {
        System.out.println("People default construct");
    }
}

class Adult extends People {
    public Adult() {
        System.out.println("Adult default construct");
    }

    public Adult(String name) {
        // super(); 默认存在 --> 会自动寻找父类的无参构造器并实现
        System.out.println("Adult construct");
    }

}
class Employee extends Adult{

    String name;
    char gender;
    int age;
    String job;
    double salary;

    public Employee() {
        this("name");
        System.out.println("Employee default construct");
    }

    public Employee(String name) {
        super("hello");
        System.out.println("Employee construct");
    }

    public Employee(String job, double salary) {
        this.job = job;
        this.salary = salary;
    }

    public Employee(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String name, char gender, int age,String job, double salary) {
        this(name, gender, age);  // 构造器的复用，this必须放在构造器的第一行，即只能复用一次
        this.job = job;
        this.salary = salary;
    }
}
