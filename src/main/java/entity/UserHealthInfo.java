/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Thinh
 */
public class UserHealthInfo {
    private int userId;
    private String gender;
    private float height;
    private float weight;
    private float activeness;
    private int age;

    public UserHealthInfo(int userId, String gender, float height, float weight, float activeness, int age) {
        this.userId = userId;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activeness = activeness;
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getActiveness() {
        return activeness;
    }

    public void setActiveness(float activeness) {
        this.activeness = activeness;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
}
