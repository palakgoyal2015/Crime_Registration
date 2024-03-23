package usecases;

import java.util.Scanner;
import dao.criminalpersondao;
import dao.criminalpersondaoIMPL;

public class registercriminalperson {
    public static void main(String[] args) {
        criminalpersondao dao = new criminalpersondaoIMPL();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Crime Place ID:");
        int crimePlaceId = sc.nextInt(); 
        sc.nextLine();

       
        
        System.out.println("How many criminal persons do you want to add?");
        int numberOfCriminals = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < numberOfCriminals; i++) {
            System.out.println("Entering details for criminal person #" + (i + 1));

            System.out.println("Enter Criminal Number:");
            int criminalNumber = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Age:");
            int age = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Enter Gender:");
            String gender = sc.nextLine();

            System.out.println("Enter Address:");
            String address = sc.nextLine();

            System.out.println("Enter Identifying Mark:");
            String identifyingMark = sc.nextLine();

            System.out.println("Enter Area of Arrest:");
            String areaofArrest = sc.nextLine();
            String addColumnResult = dao.addSuspectCountColumn();
            System.out.println(addColumnResult);
            
            String result = dao.registercriminalperson(crimePlaceId, criminalNumber, name, age, gender, address, identifyingMark, areaofArrest);
            System.out.println(result);
        }

        sc.close(); 
    }
}
