import java.util.Scanner;

class Temperature03{
   Scanner sc = new Scanner(System.in);
   private double temperature;
   private char units;

   public Temperature03() {     //default
      this.temperature = 0.0;
      this.units = 'C';
   }

   public Temperature03(double temp) {      //just temperature
      this.temperature = temp;
      this.units = 'C';
   }

   public Temperature03(char unit){      //just units
      this.units = unit;
      this.temperature = 0.0;
   }

   public Temperature03(double temp, char unit){
      this.temperature = temp;
      this.units = unit;
   }

   public void writeOutput() {
      System.out.println("Temperature03 = " + this.temperature + " degrees " + this.units + ".");
   }

   public void readInput(){              //set by inputs
      System.out.print("Enter a temperature (e.g., 29.6): ");
      temperature = sc.nextDouble();
      System.out.print("Enter the units ('C' for Celsius, 'F' for Fahrenheit): ");
      String units = sc.next().toUpperCase();
      if (!units.isEmpty()) {
         this.units = units.charAt(0);
      } else {
         this.units = 'C';
      }
   }

   public void writeC() {
      if (units == 'F' || units == 'f') {
         double tempC = (temperature - 32) * 5.0 / 9.0;
         System.out.printf("Temperature in Celsius = %.1f degrees C.%n", tempC);
      } else {
         System.out.printf("Temperature in Celsius = %.1f degrees C.%n", temperature);
      }
   }

   public void writeF(){
      if (units == 'C' || units == 'c') {
         double tempF = (temperature * 9.0 / 5.0) + 32;
         System.out.println("Temperature in Fahrenheit = " + tempF + " degrees F.");
      } else {
         System.out.println("Temperature in Fahrenheit = " + temperature + " degrees F.");
      }
   }

   public double getC() {
      if (units == 'F' || units == 'f') {
         double celsius = (temperature - 32) * 5.0 / 9.0;
         return Double.parseDouble(String.format("%.1f", celsius));
      } else {
         return Double.parseDouble(String.format("%.1f", temperature));
      }
   }

   public double getF() {
      if (units == 'C' || units == 'c') {
         double fahrenheit = (temperature * 9.0 / 5.0) + 32;
         return Double.parseDouble(String.format("%.1f", fahrenheit));
      } else {
         return Double.parseDouble(String.format("%.1f", temperature));
      }
   }

   public void set(double temp) {      //only temp
      this.temperature = temp;
   }

   public void set(double temp, char unit){    //both temp and units
      temperature = temp;
      units = unit;
   }

   public void set(char unit){      //only units
      this.units = unit;
   }

   public boolean equals(Temperature03 other) {
      double thisC = this.getC();
      double otherC = other.getC();

      return Math.abs(thisC - otherC) < 0.05;
   }

   public boolean isGreaterThan(Temperature03 other) {
      if(other.units == 'f' || other.units == 'F'){
         double temp2 = (other.temperature - 32) * 5.0 / 9.0;
         return this.temperature > temp2;
      }
      return this.temperature > other.temperature;
   }

   public boolean isLessThan(Temperature03 other){
      if(other.units == 'f' || other.units == 'F'){
         double temp2 = (other.temperature - 32) * 5.0 / 9.0;
         return this.temperature < temp2;
      }
      return this.temperature < other.temperature;
   }
}