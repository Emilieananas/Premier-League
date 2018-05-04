package models;

public class Defender extends Footballer
{
      public Defender (int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public Defender (int id, int footballerJersey, String footballerName,String footballerSalary, boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getPosition()
      {
            return "DF";
      }
      
}