package handlers;

import models.Opponent;
import handlers.FileHandler;
import java.util.Scanner;
import java.util.ArrayList;

public class OpponentHandler extends ObjectHandler<Opponent> //specifocerer hvilken type objekter vi arbejder med i denne klasse
{
      private static OpponentHandler instance;
      private ArrayList<Opponent> opponents; 
      
      //Lasse Gustafson, Erik Pilverdier
      private OpponentHandler()
      {
            opponents = getContent();
      }
      
      //Lasse Gustafson, Erik Pilverdier
      public static OpponentHandler getOpponentHandler()
      {
            if(instance == null)
            {
                  OpponentHandler oh = new OpponentHandler();
                  instance = oh;
            }
            return instance;
      }
      
      public String getFilePath()
      {
            return "opponent.csv";
      }
      
      //Emilie Bentsen, Erik Pilverdier
      public PersistentObjectHandler<Opponent> getHandler()//Returnerer en persistentObjectHandler med objectet Opponent
      {
            return new PersistentObjectHandler<Opponent>()//dette er faktisk en klasse der implementerer PersistentObjectHandler der bliver returneret
            {
                  public String lineFrom(Opponent o)//PersistentObjectHandler kr�ver vi har denne metode, modtager et objekt og laver om til en String
                  {
                        return o.getID() 
                        + "," + o.getOpponentName() 
                        + "," + o.getOpponentActive();
                  }
      
                  public Opponent objectFrom(String line)//PersistentObjectHandler kr�ver vi har denne metode, modtager en String og laver den om til et objekt og returnerer det
                  {
                        String[] components = line.split(",");
                        int id = Integer.parseInt(components[0]); //laver strings i arraylisten om til int.
                        String opponentName = components[1];
                        boolean active = Boolean.parseBoolean(components[2]);
                        
                        return new Opponent(id, opponentName, active); //obretter er nyt object af footballer                      
                  }
            };
      }

      //Emilie Bentsen, Erik Pilverdier      
      public void deleteOpponent(int id) //Metoden sletter en opponent. Metoden kalder deleteObject i ObjectHandler med ArrayList opponent og et opponentID
      {
            deleteObject(opponents, id);
      }
      
      //Emilie Bentsen, Erik Pilverdier
      public ArrayList<Opponent> getOpponentArray()//Metoden der returnerer et ArrayList opponents
      {
            return opponents;
      }
      
      //Emilie Bentsen, Erik Pilverdier
      public int getNewOpponentID()//metode til at generere nyt opponentID. Kalder metoden getNewID i ObjectHandler med ArrayList opponents
      {
            int newID= getNewID(opponents);
            return newID;
      }
      
      //Emilie Bentsen, Erik Pilverdier
      public void updateObject(int opponentID, String opponentName, boolean opponentActive) //Metode der opdatere en match vha. set metoder.
      {
            for(Opponent i : opponents)
            {
                  if (i.getID() == opponentID)
                  {
                        i.setOpponentName(opponentName);
                        i.setOpponentActive(opponentActive);
                        save(opponents);
                  }
            }
      }
      
      //Emilie Bentsen, Erik Pilverdier
      public void createObject(String opponentName, boolean opponentActive) //Metode til at oprette en ny opponent. Nyt opponentID bliver autogenereret
      {
             opponents.add(new Opponent(getNewOpponentID(), opponentName, opponentActive));
             save(opponents);
      } 
      
      
      //Adam Birch
      public ArrayList<Opponent> getActiveOpponentsArray()
      {
            ArrayList<Opponent> activeOpponents = new ArrayList<Opponent>();
            
            for(Opponent i : opponents)
            {
                  if(i.getOpponentActive() == true)
                  {
                       activeOpponents.add(i); 
                  }
            }
            return activeOpponents;
      } 
}