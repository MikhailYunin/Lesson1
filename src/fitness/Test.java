package fitness;

import java.lang.reflect.InvocationTargetException;

public class Test {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        FitnessRegisrator regisrator = new FitnessRegisrator();

        Client client1 = new Client("Ivan","Petrov",2000, "12.04.2019");
        Client client2 = new Client("Ivan","Fedorov",1995, "11.04.2019");
        Client client3 = new Client("Alexandr","Fedorov",1995, "11.04.2019");
        Client client4 = new Client("Ivan","Sidorov",1995, "11.04.2019");
        Client client5 = new Client("Petr","Sidorov",1995, "11.04.2019");
        Client client6 = new Client("Ivan","Tihomirov",1995, "11.04.2019");
        Client client7 = new Client("Vladimir","Putin",1995, "11.04.2019");
        DayClient client8 = new DayClient("Dima","Medvedev",1995);
        DayClient client9 = new DayClient("Valka","Stakan",1995);
        DayClient client10 = new DayClient("Vladimir","PPeskov",1950, "14.01.2019", 4);
        DayClient client11 = new DayClient("Car","Putin",1995);
        DayClient client12 = new DayClient("Vor","Putin",1995);
        DayClient client13 = new DayClient("Vladimir","смит",1995);
        DayClient client14 = new DayClient("Vladimir","erfg",1995);
        FullDayClient client15 = new FullDayClient("Vladimir","Monah",1995);
        FullDayClient client16 = new FullDayClient("Petr","Pervi",1995);
        FullDayClient client17 = new FullDayClient("Fedr","Bon",1995);

        regisrator.add(client1,FitnessServiceEnumiration.GYM);
        regisrator.add(client2,FitnessServiceEnumiration.POOL);
        regisrator.add(client3,FitnessServiceEnumiration.GROUP);
        regisrator.add(client4,FitnessServiceEnumiration.GYM);
        regisrator.add(client5,FitnessServiceEnumiration.POOL);
        regisrator.add(client6,FitnessServiceEnumiration.GROUP);
        regisrator.add(client7,FitnessServiceEnumiration.GYM);
        regisrator.add(client8,FitnessServiceEnumiration.POOL);
        regisrator.add(client9,FitnessServiceEnumiration.GROUP);
        regisrator.add(client10,FitnessServiceEnumiration.GYM);
        regisrator.add(client11,FitnessServiceEnumiration.POOL);
        regisrator.add(client12,FitnessServiceEnumiration.GROUP);
        regisrator.add(client13,FitnessServiceEnumiration.GYM);
        regisrator.add(client14,FitnessServiceEnumiration.POOL);
        regisrator.add(client15,FitnessServiceEnumiration.GROUP);
        regisrator.add(client16,FitnessServiceEnumiration.GYM);
        regisrator.add(client17,FitnessServiceEnumiration.POOL);


        regisrator.toPrint();




    }
}
