
package usecases;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.crimeplacedao;
import dao.crimeplacedaoIMPL;

public class registercrimeplace {
    public static void main(String[] args) {
        crimeplacedao dao = new crimeplacedaoIMPL();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Crime Number:");
        int crimeNumber = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Enter Date (YYYY-MM-DD):");
        String dateString = sc.nextLine();
        Date date = java.sql.Date.valueOf(dateString); 

        System.out.println("Enter Place:");
        String place = sc.nextLine();

        System.out.println("Enter Description:");
        String description = sc.nextLine();

        System.out.println("Enter Details:");
        String details = sc.nextLine();
        
        System.out.println("Enter number of victims:");
        int numVictims = sc.nextInt();
        sc.nextLine(); 
        List<String> victims = new ArrayList<>();
        for (int i = 0; i < numVictims; i++) {
            System.out.println("Enter Victim " + (i + 1) + ":");
            victims.add(sc.nextLine());
        }

        System.out.println("Enter number of main suspects:");
        int numSuspects = sc.nextInt();
        sc.nextLine(); 
        List<String> mainSuspects = new ArrayList<>();
        for (int i = 0; i < numSuspects; i++) {
            System.out.println("Enter Main Suspect " + (i + 1) + ":");
            mainSuspects.add(sc.nextLine());
        }


        
        String result = dao.registercrimeplace(crimeNumber, date, place, description, victims, details, mainSuspects);
        
        System.out.println(result);
    }
}

