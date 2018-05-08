package menus;
import java.util.ArrayList;
import java.util.Scanner;

public class Input
{
      public int getInt(int min, int max, String typeError, String rangeError)
      {
            while(true)
            {
                  int value = getInt(typeError);
                  if(value >= min && value <= max) return value;
                  else System.out.println(rangeError + " " + min + " - " + max);
            }
      }
      
      public int getInt(String error)
      {
            Scanner input = new Scanner(System.in);
            while(!input.hasNextInt())
            {
                  input.nextLine();
                  System.out.println(error);
            }
            return input.nextInt();
      }      
      
      public String getDate()
      {
            while(true)
            {
                  String line = getString();
                  if(line.equals("5"))
                  {
                        return "5";
                  } 
                  else if(isLocalDate(line) == true)
                  {
                        return line;
                  }
                  else System.out.println("You did not type a correct date, the format is yyyy-mm-dd ");
            }
      }
      
      public boolean isLocalDate(String line)//virker ikke helt kr�ver noget finpusning
      {
            char c ='0';
            if(line.length() == 10)
            {
                  for(int i = 0; i < 4; i++)
                  {
                        c = line.charAt(i);
                        if(Character.isDigit(c))
                        {}
                        else return false;
                  }
                  if(c == '-')
                  {}
                  else return false;
                  for(int i = 0; i < 2; i++)
                  {
                        c = line.charAt(i);
                        if(Character.isDigit(c))
                        {}
                        else return false;
                  }
                  if(c == '-')
                  {}
                  else return false; 
                  for(int i = 0; i < 2; i++)
                  {
                        c = line.charAt(i);
                        if(Character.isDigit(c))
                        {}
                        else return false;
                  }
                  return true;
            }
            else return false;
      }
      
      public static String getString(ArrayList<String> options, String error)
      {
            while(true)
            {
                  String value = getString();
                  if(options.contains(value)) return value;
                  else System.out.println(error);
            }
      }
      
      public static String getString()
      {
            Scanner input = new Scanner(System.in);
            return input.nextLine();
      }
      
      
}