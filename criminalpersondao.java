package dao;

public interface criminalpersondao {
    public String registercriminalperson( int crimePlaceId,int criminalNumber, String name, int age, String gender, String address,
    String identifyingMark, String areaofArrest);
    public String addSuspectCountColumn();
    public int getSuspectCountForCrimePlace(int crimePlaceId);
}
