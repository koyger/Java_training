package ru.stqa.java_training.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String secondName;
    private final String lastName;
    private final String nickName;
    private final String title;
    private final String company;
    private final String address;
    private final String phone;
    private final String firstEmail;
    private final String secondEmail;
    private final String homePage;
    private final String notes;

    public ContactData(String firstName, String secondName, String lastName, String nickName, String title, String company, String address, String phone, String firstEmail, String secondEmail, String homePage, String notes) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.title = title;
        this.company = company;
        this.address = address;
        this.phone = phone;
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.homePage = homePage;
        this.notes = notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getHomePage() {
        return homePage;
    }

    public String getNotes() {
        return notes;
    }
}
