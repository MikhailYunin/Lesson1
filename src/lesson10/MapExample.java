package lesson10;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User user1 = new User("qwe", "111");
        User user2 = new User("asd", "222");
        User user3 = new User("zxc", "333");
        User user4 = new User();

        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(user1.getLogin(),user1);
        userHashMap.put(user2.getLogin(),user2);
        userHashMap.put(user3.getLogin(),user3);
        userHashMap.put(null,user4);


        System.out.println(userHashMap.get("asd"));


        //---- перебор-----

//        userHashMap.keySet();
//        userHashMap.values();

        for (Map.Entry entry: userHashMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


//        LinkedHashMap - - отличается сохранением порядка при переборе

//        EnumMap (enum в качестве ключей)
        // null в качестве ключей использовать нельзя

        EnumMap<State, String> enumMap = new EnumMap<State, String>(State.class);
        enumMap.put(State.ERROR, "Ошибка");
        enumMap.put(State.START, "Старт");
        enumMap.put(State.STOP, "Стоп");

        System.out.println(enumMap.get(State.ERROR));


        // ---- сортированые по ключам будут храниться---
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "3");
        treeMap.put(1, "1");
        treeMap.put(6, "6");
        treeMap.put(2, "2");
        System.out.println(treeMap);


        WeakHashMap<Object,String> weakHashMap = new WeakHashMap<>();
        HashMap<Object,String> hashMap = new HashMap<>();


        // ключи и значения
        Object hachKey = new Object();
        String hashValue = "hashValue";

        Object weakKey = new Object();
        String weakValue = "weakValue";

        hashMap.put(hachKey, hashValue);
        weakHashMap.put(weakKey,weakValue);

        System.out.println("hashMAp" + hashMap);
        System.out.println("weakHash" + weakHashMap);

        hachKey = null;
        weakKey = null;

        System.out.println("hashMAp" + hashMap);
        System.out.println("weakHash" + weakHashMap);


        //ключи сравниваются с помощью операции == (не метода equals)
        IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<>();

        HashMap<String,Integer>  map = new HashMap<>();
        map.put("qwe",23);
        map.put("qdf",12);
        map.put("khg",67);
        map.put("pin",33);
        map.put("ppp",21);

//       так нельзя
//        for (Map.Entry<String, Integer> entry: map.entrySet()){
//            if (entry.getValue() < 20){
//                map.remove(entry.getKey());
//            }
//        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        // удаление во время итерации
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            int val = entry.getValue();
            if (val < 20) {
                iterator.remove();
            }
        }





    }



}

enum State{
    START, STOP, ERROR
}


class User{
    private String login;
    private String pwd;

    public User() {
    }

    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), pwd);
    }
}
