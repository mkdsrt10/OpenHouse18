package in.ac.iitd.openhouse.openhouseapp;



public class event {
    String name, Stime,Etime;

    public event(String Stime, String Etime, String name) {
        this.name = name;
        this.Stime = Stime.substring( 11 , 16);
        this.Etime = Etime.substring(11,16);

    }

    public String getName() { return name;}

    public String getStime() { return Stime; }

    public String getETime() { return Etime; }
}
