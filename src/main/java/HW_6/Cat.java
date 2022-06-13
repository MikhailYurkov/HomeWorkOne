package HW_6;

public class Cat extends Animals {
    private static int count;

    public Cat(String type, String name,int run,int swim) {
        this.type = type;
        this.name = name;
        this.run = run;
        this.swim = swim;

        count++;
    }

    public static int getCount() {
        return count;
    }
    public static void run(int distance) {
        if (run >= distance) {
            System.out.println(type + " по кличке " + name + "  - УСПЕШНО пробежал " + distance + "м.");
        } else {
            System.out.println(type + " по кличке " + name + " сошел с дистанции ");
        }
    }

    public static void swim(int distance) {
        if (swim >= distance) {
            System.out.println(type + " по кличке " + name + " УСПЕШНО проплыл  " + distance + "м.");
        } else {
            System.out.println(type + " по кличке " + name + " не умеет плавать");
        }
    }
}





