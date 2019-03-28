package lesson7;

public class Lesson7 {
    public static void main(String[] args) {
        int a=5;
        Integer intVar = 5;
        Float floatVar;
        Double doubleVar;
        Character character;
        Short shortVar;
        Boolean bool;


        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);

        // методы преобразующие строку в число

        System.out.println(Byte.parseByte("2"));
        System.out.println(Byte.valueOf("2"));

        System.out.println(Integer.parseInt("2"));
        System.out.println(Integer.valueOf("2"));

        Integer int1 = 2;
        Integer int2 = 2;

        if (int1==int2) {
            System.out.println("int1 == int2" );
        }
        Integer int3 = 300;
        Integer int4 = 300;
        if (int3==int4) {
            System.out.println("int3 == int4" );
        }

        Integer.compare(int1,int2);
        Integer.max(int1,int2);
        Integer.min(int1,int2);

        Integer.hashCode(45);
        Integer.sum(int1,int2);


        System.out.println(Integer.parseInt("sdf25r2"));

        int1.longValue(); // возвращает примитив





    }
}
