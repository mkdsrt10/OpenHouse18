package in.ac.iitd.openhouse.openhouseapp;

/**
 * Created by mayankdubey on 11/04/18.
 */

public class StudentCoordi {
    String name, email, phone;
    static int image;

    public StudentCoordi(String name, String email, String phone, int image) {
        this.name = name;
        this.email = email;
        this.image = image;
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

    public static int getImage() {
        return image;
    }

}