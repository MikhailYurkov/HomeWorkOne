package homeWork5;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Петров Иван", "Специалист", "11@gmail.com", "+798641661", 150000, 34);

        employee1.printInfo();

        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan1", "Engineer", "ivivan1@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Employee("Ivanov Ivan2", "developer", "ivivan2@mailbox.com", "892312312", 306000, 40);
        persArray[2] = new Employee("Ivanov Ivan3", "programmer", "ivivan3@mailbox.com", "892312312", 300500, 50);
        persArray[3] = new Employee("Ivanov Ivan4", "SEO", "ivivan4@mailbox.com", "892312312", 300000, 39);
        persArray[4] = new Employee("Ivanov Ivan5", "HR", "ivivan5@mailbox.com", "892312312", 31000, 38);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].Age > 40) {
                persArray[i].printInfo();
            }
        }
    }
}
