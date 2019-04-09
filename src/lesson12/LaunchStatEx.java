package lesson12;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatEx implements Externalizable {
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

private static final  long serialVersion = 0L;


    private int launchCount;
    private Date lastLaunch;

    public boolean isFirstLaunch(){
        return launchCount == 0 && lastLaunch == null;
    }


}
