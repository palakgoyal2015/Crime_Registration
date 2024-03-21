package usecases;

import java.util.Scanner;
import dao.totalcrimeIMPL;
import dao.totalcrimedao;

public class totalcrimecases {
    public static void main(String[] args) {
        totalcrimedao dao = new totalcrimeIMPL();
        Scanner sc = new Scanner(System.in);
        int numberOfCrimes = dao.getNumberOfCrimes();
        System.out.println("Total number of crimes recorded: " + numberOfCrimes);
        int numberOfSolvedCases = dao.getNumberOfSolvedCases();
        System.out.println("Total number of solved cases: " + numberOfSolvedCases);
        int numberOfUnsolvedCases = dao.getNumberOfUnsolvedCases();
        System.out.println("Total number of unsolved cases: " + numberOfUnsolvedCases);
        int numberofsolvedcasesinparticularmonth=dao.getNumberOfCrimesInCurrentMonth();
        System.out.println("TOtal number of cases in current month: "+numberofsolvedcasesinparticularmonth);
       int numberofsolvedcasesincurrentmonth=dao.getNumberOfSolvedCrimesInCurrentMonth();
       System.out.println("Total number of solved in current month:"+numberofsolvedcasesincurrentmonth);
        sc.close();
    }
}


