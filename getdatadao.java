package dao;

import exceptions.Invalidcrimenumber;
import exceptions.Invalidcriminalnumber;

public interface getdatadao {
     public String getdatabycrimenumber(int crimeNumber)throws Invalidcrimenumber;
     public String getdatabycriminalnumber(int criminalNumber)throws Invalidcriminalnumber;
}
