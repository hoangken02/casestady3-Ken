package model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private int centerId;

    public User(String firstName, String lastName, String useName, String password, String email, String password1, String phoneNumber, int centerId) {
    }

    public User(String firstname, String lastname, String username, String password, String email, String phoneNumber, int centerId) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public User(int id, String firstName, String lastName, String account, String password, String email, String phoneNumber, int centerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = account;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.centerId = centerId;
    }

    public User() {
    }
}
