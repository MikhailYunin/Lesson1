package fitness;

import lesson11.excetpions.CheckedException;
import lesson11.excetpions.UncheckedException;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class FitnessRegisrator {
    ArrayList<Human> inGym = new ArrayList<>();
    ArrayList<Human> inPool = new ArrayList<>();
    ArrayList<Human> inGroup = new ArrayList<>();

    public void add(Human human, FitnessServiceEnumiration type) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        if (FitnessServiceEnumiration.GYM.equals(type)) {
            int count=0;
            for (Human e : inGym){
                count +=1;
            }
            try {
                checkExceptionQueue(count);
                inGym.add(human);
                FitnessLogger.writeToFile(human,"GYM");
            } catch (CheckedException e) {
                System.out.println("CheckedException " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        if (FitnessServiceEnumiration.POOL.equals(type)) {

            int count=0;
            for (Human e : inPool){
                count +=1;
            }
            try {

                checkExceptionQueue(count);
                inPool.add(human);
                FitnessLogger.writeToFile(human,"Pool");
            } catch (CheckedException e) {
                System.out.println("CheckedException " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (FitnessServiceEnumiration.GROUP.equals(type)) {
            int count=0;
            for (Human e : inGroup){
                count +=1;
            }
            try {
                checkExceptionQueue(count);
                inGroup.add(human);
                FitnessLogger.writeToFile(human,"Group");
            } catch (CheckedException e) {
                System.out.println("CheckedException " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void toPrint(){
        Comparator<Human> clientComparator = new SurnameComparator().thenComparing(new NameComparator());

        TreeSet<Human> gymTreeSet = new TreeSet<>(clientComparator);
        for (Human e: inGym){
            gymTreeSet.add(e);
        }
        TreeSet<Human> poolTreeSet = new TreeSet<>(clientComparator);
        for (Human e: inPool){
            poolTreeSet.add(e);
        }
        TreeSet<Human> groupTreeSet = new TreeSet<>(clientComparator);
        for (Human e: inGroup){
            groupTreeSet.add(e);
        }


        for (Human human: gymTreeSet){
            System.out.println("<"+human.getSurname()+ "> <" + human.getName()+"> <"+human.getTypeClient()+"> <в тренажерном зале>");
        }
        for (Human human: poolTreeSet){
            System.out.println("<"+human.getSurname()+ "> <" + human.getName()+"> <"+human.getTypeClient()+"> <в бассейне>");
        }
        for (Human human: groupTreeSet){
            System.out.println("<"+human.getSurname()+ "> <" + human.getName()+"> <"+human.getTypeClient()+"> <на групповых занятиях>");
        }

    }



    public void remove(Human human){
        for (Human e : inGym){
            if (e.equals(human)){
                inGym.remove(e);
            }
        }
        for (Human e : inPool){
            if (e.equals(human)){
                inPool.remove(e);
            }
        }
        for (Human e : inGroup){
            if (e.equals(human)){
                inGroup.remove(e);
            }
        }
    }





    public static void checkExceptionQueue(int i) throws CheckedException {
        if (i > 20){
            throw new CheckedException("QueueException");
        }
    }


    public static void checkExceptionAccess(FitnessServiceEnumiration typeClient, FitnessServiceEnumiration typeAcess, Human human) throws CheckedException {
        if (typeClient.equals(typeClient)){
            //human.
            throw new CheckedException("NoAccessException");
        }
    }
}

class SurnameComparator implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}

class NameComparator implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

