package dao;

import java.sql.Date;
import java.util.List;

public interface totalcrimedao {
    
  
    int getNumberOfCrimes();
    int getNumberOfSolvedCases();
    int getNumberOfUnsolvedCases();
    int getNumberOfCrimesInCurrentMonth();
    int getNumberOfSolvedCrimesInCurrentMonth();

}
