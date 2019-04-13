package fitness;

import java.util.ArrayList;

public class FitnessRegisrator {
    ArrayList<Human> inGym = new ArrayList<>();
    ArrayList<Human> inPool = new ArrayList<>();
    ArrayList<Human> inGroup = new ArrayList<>();

    public void add(Human human, FitnessServiceEnumiration type){
        if (FitnessServiceEnumiration.GYM.equals(type)) {

            inGym.add(human);

        }

    }
}
