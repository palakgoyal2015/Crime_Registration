package bean;

import java.sql.Date;
import java.util.List;

public class crimeplace {
    private int crimeNumber; 
    private Date date;
    private String place;
    private String description;
    private List<String> victims;
    private String details;
    private List<String> mainSuspects;
    
    public crimeplace(int crimeNumber,Date date,String place,String description,List<String> victims,String details,List<String> mainSuspects){
        this.crimeNumber=crimeNumber;
        this.date=date;
        this.place=place;
        this.description=description;
        this.victims=victims;
        this.details=details;
        this.mainSuspects=mainSuspects;
    }
    public int getCrimeNumber() {
        return crimeNumber;
    }

    public Date getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getVictims() {
        return victims;
    }

    public String getDetails() {
        return details;
    }

    public List<String> getMainSuspects() {
        return mainSuspects;
    }
    
   
    public void setCrimeNumber(int crimeNumber) {
        this.crimeNumber = crimeNumber;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVictims(List<String> victims) {
        this.victims = victims;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setMainSuspects(List<String> mainSuspects) {
        this.mainSuspects = mainSuspects;
    }
    @Override
    public String toString() {
        return "crimeplace{" +
                "crimeNumber=" + crimeNumber +
                ", date=" + date +
                ", place='" + place + '\'' +
                ", description='" + description + '\'' +
                ", victims=" + victims +
                ", details='" + details + '\'' +
                ", mainSuspects=" + mainSuspects +
                '}';
    }
}

