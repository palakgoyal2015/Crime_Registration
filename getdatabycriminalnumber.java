package usecases;

import java.util.Scanner;

import dao.getdatadao;
import dao.getdatadaoIMPL;
import exceptions.Invalidcriminalnumber;

public class getdatabycriminalnumber {
    public static void main(String[] args) {
         getdatadao dao = new getdatadaoIMPL();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Criminal Number:");
        int criminalNumber = sc.nextInt();

        try {
            String criminalInformation = dao.getdatabycriminalnumber(criminalNumber);
            System.out.println(criminalInformation);
        } catch (Invalidcriminalnumber e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
