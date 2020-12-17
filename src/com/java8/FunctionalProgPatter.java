package com.java8;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgPatter {

    public static void main(String[] args) {

        List<User> userList=new ArrayList<>();
        userList.add(new User("amit","Bhadana")); userList.add(new User("pa","jan"));
        userList.add(new User("pa2","jan2")); userList.add(new User("pa1","jan1"));

        System.out.println(userList);

        List<UserDto> userDtoList= new FunctionalProgPatter().getUserToDao(userList);

        System.out.println(userDtoList);

    }

    public List<UserDto> getUserToDao(List<User> user) {
        return user.stream()
                .map(this::toDo)
                .collect(Collectors.toList());
    }

    public UserDto toDo(User user){
        UserDto userDto=new UserDto();
        userDto.setFullName(user.getFirstName()+ " "+ user.getLastName());
        return userDto;
    }

}

class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

class UserDto {
    private String fullName;

    UserDto(){

    }

    public UserDto(String fullName) {
        this.fullName = fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
