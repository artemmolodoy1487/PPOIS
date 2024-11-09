package by.starovoitov.shop.logic;

public class Men {

    public String email;
    public String name;
    public Men(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Men(){
        this.email = "invalid";
        this.name = "invalid";
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
