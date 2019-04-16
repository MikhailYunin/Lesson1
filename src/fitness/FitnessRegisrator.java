package fitness;

import lesson11.excetpions.CheckedException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class FitnessRegisrator {
    ArrayList<Human> inGym = new ArrayList<>();
    ArrayList<Human> inPool = new ArrayList<>();
    ArrayList<Human> inGroup = new ArrayList<>();

    public void add(Human human, FitnessServiceEnumiration type) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        AccessMode methodInfo = human.getClass().getDeclaredAnnotation(AccessMode.class); // получаем доступ к аннотациям класса
        if (FitnessServiceEnumiration.GYM.equals(type)) {
            int count = 0;
            for (Human e : inGym) {
                count += 1; // считаем текущее количество людей на занятии
            }
            try {
                checkExceptionAccess(methodInfo.gym()); // проверка на доступ по времени, через аннотацию
                checkExceptionQueue(count); // проверка на количество человек на занятии
                inGym.add(human);
                FitnessLogger.writeToFile(human, "GYM"); //логируем
            } catch (CheckedException e) {
                System.out.println("CheckedException " + e.getMessage());
                try {
                    FitnessLogger.writeNoAccess(human, type);  // логируем отказ в доступе
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (FitnessServiceEnumiration.POOL.equals(type)) {

            int count = 0;
            for (Human e : inPool) {
                count += 1;
            }
            try {
                checkExceptionAccess(methodInfo.pool());
                checkExceptionQueue(count);
                inPool.add(human);
                FitnessLogger.writeToFile(human, "Pool");
            } catch (CheckedException e) {
                System.out.println("CheckedException " + e.getMessage());
                try {
                    FitnessLogger.writeNoAccess(human, type);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (FitnessServiceEnumiration.GROUP.equals(type)) {
            int count = 0;
            for (Human e : inGroup) {
                count += 1;
            }
            try {
                checkExceptionAccess(methodInfo.group());
                checkExceptionQueue(count);
                inGroup.add(human);
                FitnessLogger.writeToFile(human, "Group");
            } catch (CheckedException e) {
                System.out.println("CheckedException " + e.getMessage());
                try {
                    FitnessLogger.writeNoAccess(human, type);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void toPrint() {

        System.out.println( "Люди, которые сейчас на занятиях: ");
        Comparator<Human> clientComparator = new SurnameComparator().thenComparing(new NameComparator());

        TreeSet<Human> gymTreeSet = new TreeSet<>(clientComparator);
        for (Human e : inGym) {
            gymTreeSet.add(e);
        }
        TreeSet<Human> poolTreeSet = new TreeSet<>(clientComparator);
        for (Human e : inPool) {
            poolTreeSet.add(e);
        }
        TreeSet<Human> groupTreeSet = new TreeSet<>(clientComparator);
        for (Human e : inGroup) {
            groupTreeSet.add(e);
        }


        for (Human human : gymTreeSet) {
            System.out.println("<" + human.getSurname() + "> <" + human.getName() + "> <" + human.getTypeClient() + "> <в тренажерном зале>");
        }
        for (Human human : poolTreeSet) {
            System.out.println("<" + human.getSurname() + "> <" + human.getName() + "> <" + human.getTypeClient() + "> <в бассейне>");
        }
        for (Human human : groupTreeSet) {
            System.out.println("<" + human.getSurname() + "> <" + human.getName() + "> <" + human.getTypeClient() + "> <на групповых занятиях>");
        }

    }


    public void remove(Human human) {

        Iterator<Human> humanIterator = inGym.iterator();//создаем итератор
        while(humanIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            Human nextHuman = humanIterator.next();//получаем следующий элемент
            if (nextHuman.equals(human)) {
                humanIterator.remove();//удаляем клиента из занятия
            }
        }

        Iterator<Human> humanIterator2 = inPool.iterator();
        while(humanIterator2.hasNext()) {
            Human nextHuman = humanIterator2.next();
            if (nextHuman.equals(human)) {
                humanIterator2.remove();
            }
        }

        Iterator<Human> humanIterator3 = inGroup.iterator();
        while(humanIterator3.hasNext()) {
            Human nextHuman = humanIterator3.next();
            if (nextHuman.equals(human)) {
                humanIterator3.remove();
            }
        }


    }


    public static void checkExceptionQueue(int i) throws CheckedException {
        if (i > 20) {
            throw new CheckedException("QueueException");
        }
    }

    public static void checkExceptionAccess(String finishTime) throws CheckedException {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("k");
        int finishTime2 = Integer.parseInt(finishTime); // время, окончания доступа к занятию
        int curTime = Integer.parseInt(time.format(formatter2)); // текущий час

        if (finishTime2 < 8 | finishTime2 <= curTime) {
            throw new CheckedException("NoAccessException");
        }
    }

}

class SurnameComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}

class NameComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

