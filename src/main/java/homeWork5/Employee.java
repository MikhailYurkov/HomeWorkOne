package homeWork5;

public class Employee {
    String fullNname;
    String position;
    String Email;
    String Tel;
    int pay;
    int Age;

    public Employee(String fullNname, String position, String email, String tel, int pay, int age) {
        this.fullNname = fullNname;
        this.position = position;
        Email = email;
        Tel = tel;
        this.pay = pay;
        Age = age;
    }

    void printInfo() {
        System.out.printf(" ���������: %s%n ���������: %s%n email: %s%n �������: %s%n ��������: %d%n �������: %d ���%n%n", fullNname, position, Email, Tel, pay, Age);
    }

}
