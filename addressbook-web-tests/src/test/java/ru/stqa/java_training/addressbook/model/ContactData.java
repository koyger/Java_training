package ru.stqa.java_training.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
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
    private String group;

    public ContactData(int id, String firstName, String secondName, String lastName, String nickName, String title,
                       String company, String address, String phone, String firstEmail, String secondEmail,
                       String homePage, String notes, String group) {
        this.id = id;
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
        this.group = group;
    }

    public ContactData(String firstName, String secondName, String lastName, String nickName, String title,
                       String company, String address, String phone, String firstEmail, String secondEmail,
                       String homePage, String notes, String group) {
        this.id = Integer.MAX_VALUE;
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
        this.group = group;
    }

    public int getId() {
        return id;
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

    public String getGroup() { return group; }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }

}
