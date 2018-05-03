package handlers;

import java.util.ArrayList;

public abstract class ObjectHandler<T extends Object> //T kan v�re enhver type af objekter som extender Object klassen "den som findes i forevejen"
{
      public abstract String getFilePath(); //Metode der skal implementeres af klasser som nedarver fra klassen. Denne metode returnerer en String
      public abstract PersistentObjectHandler<T> getHandler(); //metode der skal implemteres af klasser som nedarver fra klassen. Denne medtode returnere et interface
      
      public ArrayList<T> getContent() //metode der nedarves hvis ikke de overskrives i subklassen. Returnerer en ArrayList der indeholder objekter T
      {
            return FileHandler.getContent(getFilePath(), getHandler());
      }
      
      public void save(ArrayList<T> list) //metode der nedarves hvis ikke de overskrives i subklassen. Returnerer ikke noget. Har en ArrayList med objekter af T der hedder "lis" som parameter.
      {
            FileHandler.save(getFilePath(), list, getHandler());
      }
}