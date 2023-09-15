package classes;

public class Appointment {

    private String appID;
    private String date;
    private String time;
    private String phoneNumber;
    private String department;
    private String username;

    public Appointment(String date, String time, String phoneNumber, String department, String username) {
        this.date = date;
        this.time = time;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.username = username;
    }

    public Appointment(String appID, String date, String time, String phoneNumber, String department, String username) {
        this.appID = appID;
        this.date = date;
        this.time = time;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.username = username;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}