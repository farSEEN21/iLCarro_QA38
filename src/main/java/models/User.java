package models;

public class User {

    String name;
    String lastname;
    String email;
    String psw;

//    public User(String name, String lastname, String email, String psw) {
//        this.name = name;
//        this.lastname = lastname;
//        this.email = email;
//        this.psw = psw;
//    }
//
//    public User(String email, String psw) {
//        this.email = email;
//        this.psw = psw;
//    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }


 public  User withName(String name) {

       this.name=name;
     return this;
    }

    public User withLastname(String lastname) {
        this.lastname = lastname;
    return this;
    }

    public User withEmail(String email) {
        this.email = email;
    return this;
    }

    public User withPsw(String psw) {
        this.psw = psw;
    return this
    }
}
