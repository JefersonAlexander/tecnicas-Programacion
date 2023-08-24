import java.util.*;

public class Main {
    public static void main(String[] args) {
      
      
      System.out.println("Ejercicioo 1 ---------------------" );
      double[] celsius= {0, 100,25, -10};
      double[] fahrenheit= {32, 100, -40};
      
      double fahrenheit_Convertido;
      double celsius_Convertido;
      
      for (int i = 0; i < 4; i++){
        fahrenheit_Convertido = (celsius[i] * (9.0/5.0)) + 32;
        System.out.println(celsius[i] + "  Grados centigrados a fahrenheit es " + fahrenheit_Convertido);
      };
      
      for (int i = 0; i < 3; i++){
        celsius_Convertido = (fahrenheit[i] - 32 ) * (5.0/9.0);
        System.out.println(fahrenheit[i] + "  fahrenheit a grados centigrados es " + celsius_Convertido);
      };
      
      
      System.out.println( );
      System.out.println("Ejercicioo 2 ---------------------" );

      
      double[] numbers = {40, 50, 60, 24, 66, 12,98};
      double total=0;
      double average=0;
      
      for (int i = 0; i < numbers.length; i++){
        total += numbers[i];
      };
      
      average=total / 7;
      
      for (int i = 0; i < 7; i++){
        if(numbers[i] < average){
          System.out.println("El numero "  + numbers[i] + " Es menor que el promedio "+ average );
        }else if(numbers[i] == average){
          System.out.println("El numero "  + numbers[i] + " Es igual al promedio  "+ average );
        }else{
          System.out.println("El numero " + numbers[i] + " Es mayor que el promedio " + average );
        };
      };
      
       System.out.println("El promedio de todos los numeros es " + average);
  }
}
