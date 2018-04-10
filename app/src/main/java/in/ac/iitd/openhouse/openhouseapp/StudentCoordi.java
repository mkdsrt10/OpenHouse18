package in.ac.iitd.openhouse.openhouseapp;

/**
 * Created by mayankdubey on 11/04/18.
 */

public class StudentCoordi {
    String name, email, imageUrl, phone;

    public StudentCoordi(String name, String email, String phone) {
        this.name = name;
        this.email = email;
//        this.imageUrl = imageUrl;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
