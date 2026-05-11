import java.util.Scanner;
class Temperature01 {
   private double temperature;
   private char units;

   public Temperature01() {
      this.temperature = 0.0;
      this.units = 'C';
   }

   public Temperature01(double temp) {
      this.temperature = temp;
      this.units = 'C';
   }

   public void writeOutput() {
      System.out.println("Temperature01 = " + temperature + " degrees " + units + ".");
   }
}
public class TemperatureTest01
{
   public static void main(String[] args)
   {
      System.out.println();
      System.out.println("Test case 1: default constructor and");
      System.out.println("writeOutput() method.");
      System.out.println();
      Temperature01 t1 = new Temperature01();
      System.out.println("Results of default constructor:");
      System.out.println("Verify 0 degrees C.");
      System.out.println();
      t1.writeOutput();
      System.out.println();
      System.out.println("==========================================");
      System.out.println("Test case 3: constructor with just temperature.");
      Temperature01 t2 = new Temperature01(20.5);
      System.out.println();
      System.out.println("Verify 20.5 degrees C.");
      System.out.println();
      t2.writeOutput();
      System.out.println();
      System.out.println("==========================================");

 }
}
