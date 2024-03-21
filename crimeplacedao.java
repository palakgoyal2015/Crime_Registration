package dao;

import java.sql.Date;
import java.util.List;

import bean.crimeplace;

public interface crimeplacedao {
     public String registercrimeplace(int crimeNumber,Date date,String place,String description,List<String> victims,String details,List<String> mainSuspects);
}
