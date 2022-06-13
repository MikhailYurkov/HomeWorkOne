package HW_6;

public class AnimalsApp {
    public static void main(String[] args) {

        new Cat("Кот", "Мурзик", 200, 0);
        Cat.run(150);
        Cat.swim(10);
        System.out.println( "--- ");
        new Cat("Кошка", "Алиса", 200, 0);
        Cat.run(210);
        Cat.swim(10);
        System.out.println(" --- ");
        new Dog("Собака", "Бобик", 500, 10);
        Dog.run(350);
        Dog.swim(10);
        System.out.println( "---" );
        new Dog("Собака", "Лора", 500, 10);
        Dog.run(550);
        Dog.swim(11);
        System.out.println( "---" );

        System.out.println("Всего котов создано: " + Cat.getCount());
        System.out.println("Всего собак создано: " + Dog.getCount());
        System.out.println("Всего животных создано: " + Animals.getCount());

    }
}




