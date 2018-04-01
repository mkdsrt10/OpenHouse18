package in.ac.iitd.openhouse.openhouseapp;

/**
 * Created  by mayankdubey on 01/04/18.
 */

public class event {
    String name, time;

    public event(String time, String name) {
        this.name = name;
        this.time = time.substring(11, 16);

    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;

    }
}
