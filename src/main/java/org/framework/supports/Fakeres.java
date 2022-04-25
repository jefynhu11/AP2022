package org.framework.supports;

import com.github.javafaker.Faker;

public class Fakeres {

    private Faker faker = new Faker();
    private String firstName, lastName;
    private String password, email, mobilePhone;
    private String address, city,postalCode;

    public String getFirstName() {
        return firstName = faker.name().firstName();
    }
    public String getLastName() {
        return lastName = faker.name().lastName();
    }
    public String getPassword() {
        return password = faker.internet().password();
    }
    public String getEmail() {
        return email = faker.internet().emailAddress();
    }
    public String getMobilePhone() {
        return  mobilePhone = faker.phoneNumber().phoneNumber();
    }
    public String getAddress() {
        return address = faker.address().streetAddress();
    }
    public String getCity(){
        return city = faker.address().cityName();
    }
    public String getPostalCode() {
        return postalCode = faker.address().zipCode();
    }
}
