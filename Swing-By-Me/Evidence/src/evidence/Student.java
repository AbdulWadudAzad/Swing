/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidence;

/**
 *
 * @author User
 */
public class Student {

    private String name;
    private String email;
    private String age;
    private String gender;
    private String hobby;
    private String round;
    private String message;

    public Student() {
    }

    public Student(String name, String email, String age, String gender, String hobby, String round, String message) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
        this.round = round;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getHobby() {
        return hobby;
    }

    public String getRound() {
        return round;
    }

    public String getMessage() {
        return message;
    }

 
    
    
}
