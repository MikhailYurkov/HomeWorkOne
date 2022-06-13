package HW_6;

public class Animals {
    protected static String type;
    static String name;
    static int run;
    static int swim;
    private static int count;


    public Animals(String name) {
        this.name = name;
    }

    public Animals() {
        count++;
    }
    public static int getCount() {
        return count;
    }

}



