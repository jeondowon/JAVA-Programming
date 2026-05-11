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