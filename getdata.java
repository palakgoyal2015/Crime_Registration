package usecases;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.crimeplacedao;
import dao.crimeplacedaoIMPL;
import dao.criminalpersondao;
import dao.criminalpersondaoIMPL;
import dao.getdatadao;
import dao.getdatadaoIMPL;
import dao.totalcrimeIMPL;
import dao.totalcrimedao;
import exceptions.Invalidcrimenumber;
import exceptions.Invalidcriminalnumber;

public class getdata {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter what you want:");
        String input = scanner.nextLine();

        switch (input) {
            case "get data by crime number":
                getDataByCrimeNumber();
                break;
            case "get data by crime place":
                getDataByCrimePlace();
                break;
            case "register crime place":
                registerCrimePlace();
                break;
            case "register criminal person":
                registerCriminalPerson();
                break;
            case "get total data":
                getTotalData();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    private static void getDataByCrimeNumber() {
        getdatadao dao = new getdatadaoIMPL();
        System.out.println("Enter Crime Number:");
        int crimeNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try {
            String crimeInformation = dao.getdatabycrimenumber(crimeNumber);
            System.out.println(crimeInformation);
        } catch (Invalidcrimenumber e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getDataByCrimePlace() {
        getdatadao dao = new getdatadaoIMPL();
        System.out.println("Enter Criminal Number:");
        int criminalNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try {
            String criminalInformation = dao.getdatabycriminalnumber(criminalNumber);
            System.out.println(criminalInformation);
        } catch (Invalidcriminalnumber e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerCrimePlace() {
        crimeplacedao dao = new crimeplacedaoIMPL();
        System.out.println("Enter Crime Number:");
        int crimeNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Date (YYYY-MM-DD):");
        String dateString = scanner.nextLine();
        Date date = java.sql.Date.valueOf(dateString);
        System.out.println("Enter Place:");
        String place = scanner.nextLine();
        System.out.println("Enter Description:");
        String description = scanner.nextLine();
        System.out.println("Enter Details:");
        String details = scanner.nextLine();
        System.out.println("Enter number of victims:");
        int numVictims = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<String> victims = new ArrayList<>();
        for (int i = 0; i < numVictims; i++) {
            System.out.println("Enter Victim " + (i + 1) + ":");
            victims.add(scanner.nextLine());
        }
        System.out.println("Enter number of main suspects:");
        int numSuspects = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<String> mainSuspects = new ArrayList<>();
        for (int i = 0; i < numSuspects; i++) {
            System.out.println("Enter Main Suspect " + (i + 1) + ":");
            mainSuspects.add(scanner.nextLine());
        }
        String addstatus = dao.addStatusColumn();
        System.out.println(addstatus);
        String result = dao.registercrimeplace(crimeNumber, date, place, description, victims, details, mainSuspects);
        System.out.println(result);
    }

    private static void registerCriminalPerson() {
        criminalpersondao dao = new criminalpersondaoIMPL();
        System.out.println("Enter Crime Place ID:");
        int crimePlaceId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("How many criminal persons do you want to add?");
        int numberOfCriminals = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numberOfCriminals; i++) {
            System.out.println("Entering details for criminal person #" + (i + 1));
            System.out.println("Enter Criminal Number:");
            int criminalNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Age:");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter Gender:");
            String gender = scanner.nextLine();
            System.out.println("Enter Address:");
            String address = scanner.nextLine();
            System.out.println("Enter Identifying Mark:");
            String identifyingMark = scanner.nextLine();
            System.out.println("Enter Area of Arrest:");
            String areaofArrest = scanner.nextLine();
            String addColumnResult = dao.addSuspectCountColumn();
            System.out.println(addColumnResult);
            String result = dao.registercriminalperson(crimePlaceId, criminalNumber, name, age, gender, address, identifyingMark, areaofArrest);
            System.out.println(result);
        }
    }

    private static void getTotalData() {
        totalcrimedao dao = new totalcrimeIMPL();
        int numberOfCrimes = dao.getNumberOfCrimes();
        System.out.println("Total number of crimes recorded: " + numberOfCrimes);
        int numberOfSolvedCases = dao.getNumberOfSolvedCases();
        System.out.println("Total number of solved cases: " + numberOfSolvedCases);
        int numberOfUnsolvedCases = dao.getNumberOfUnsolvedCases();
        System.out.println("Total number of unsolved cases: " + numberOfUnsolvedCases);
        int numberofsolvedcasesinparticularmonth = dao.getNumberOfCrimesInCurrentMonth();
        System.out.println("Total number of cases in current month: " + numberofsolvedcasesinparticularmonth);
        int numberofsolvedcasesincurrentmonth = dao.getNumberOfSolvedCrimesInCurrentMonth();
        System.out.println("Total number of solved in current month:" + numberofsolvedcasesincurrentmonth);
    }
}
