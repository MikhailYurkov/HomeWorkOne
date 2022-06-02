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
        System.out.printf(" Сотрудник: %s%n должность: %s%n email: %s%n телефон: %s%n зарплата: %d%n возраст: %d лет%n%n", fullNname, position, Email, Tel, pay, Age);
    }

}
