package app.vs.college;

public class UserData {
    public UserData(String name, String email, Float height) {
        this.name = name;
        this.email = email;
        this.height = height;
    }

    public UserData() {
    }

    public UserData(String name, String email, float height, int age) {
        this.name = name;
        this.email = email;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    private String name;
    private String email;
    private Float height;
}
