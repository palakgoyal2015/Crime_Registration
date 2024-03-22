package usecases;

import java.util.Scanner;

import dao.getdatadao;
import dao.getdatadaoIMPL;
import exceptions.Invalidcrimenumber;

public class getdatabycrimenumber {
    public static void main(String[] args) {
        getdatadao dao = new getdatadaoIMPL();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Crime Number:");
        int crimeNumber = sc.nextInt();
        
        try {
            String crimeInformation = dao.getdatabycrimenumber(crimeNumber);
            System.out.println(crimeInformation);
        } catch (Invalidcrimenumber e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
