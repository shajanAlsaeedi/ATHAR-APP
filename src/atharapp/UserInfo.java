/** 
 * ## User Info ##.
 */
package atharapp;

import java.io.Serializable;

public class UserInfo implements Serializable  {
    
    private String name;
    private String phone;
    private String email;
    private String poeple;
    private String museum;
    private String date;
    private String time1;
    private String time2;
    private String price;

    public UserInfo(String name, String phone, String email, String poeple, 
            String museum, String date, String time1, String time2, String price ) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.poeple = poeple;
        this.museum = museum;
        this.date = date;
        this.time1 = time1;
        this.time2 = time2;
        this.price = price ;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPoeple() {
        return poeple;
    }

    public String getMuseum() {
        return museum;
    }

    public String getDate() {
        return date;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoeple(String poeple) {
        this.poeple = poeple;
    }

    public void setMuseum(String museum) {
        this.museum = museum;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
        
    
}
