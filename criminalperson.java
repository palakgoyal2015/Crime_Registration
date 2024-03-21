package bean;

import java.util.List;

public class criminalperson {
    private int criminalNumber; 
    private String name;
    private int age;
    private String gender;
    private String address;
    private String identifyingMark;
    private String areaOfArrest;
    private int crimePlaceId;
   
    public criminalperson(int crimePlaceId,int criminalNumber,String name,int age,String gender,String address,String identifyingMark,String areaofArrest){
        this.criminalNumber=criminalNumber;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.address=address;
        this.identifyingMark=identifyingMark;
        this.areaOfArrest=areaofArrest;
        this.crimePlaceId=crimePlaceId;
    }
    public int getCriminalNumber() {
        return criminalNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getIdentifyingMark() {
        return identifyingMark;
    }

    public String getAreaOfArrest() {
        return areaOfArrest;
    }

 
    public void setCriminalNumber(int criminalNumber) {
        this.criminalNumber = criminalNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIdentifyingMark(String identifyingMark) {
        this.identifyingMark = identifyingMark;
    }

    public void setAreaOfArrest(String areaOfArrest) {
        this.areaOfArrest = areaOfArrest;
    }


    public int getCrimePlaceId() {
        return crimePlaceId;
    }

    public void setCrimePlaceId(int crimePlaceId) {
        this.crimePlaceId = crimePlaceId;
    }

    @Override
    public String toString() {
        return "criminalperson{" +
                "criminalNumber=" + criminalNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", identifyingMark='" + identifyingMark + '\'' +
                ", areaOfArrest='" + areaOfArrest + '\'' +
                ", crimePlaceId=" + crimePlaceId +
                '}';
    }
}
