import java.util.Scanner;
class Temperature02{
    Scanner sc = new Scanner(System.in);
    private double temperature;
    private char units;

    public Temperature02() {     //default
        this.temperature = 0.0;
        this.units = 'C';
    }

    public Temperature02(double temp) {      //just temperature
       this.temperature = temp;
       this.units = 'C';
    }

    public Temperature02(char unit){      //just units
       this.units = unit;
       this.temperature = 0.0;
    }

    public Temperature02(double temp, char unit){
       this.temperature = temp;
       this.units = unit;
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

    public void writeOutput() {
        System.out.println("Temperature02 = " + temperature + " degrees " + units + ".");
    }

}

public class TemperatureTest02
{
   public static void main(String[] args)
   {
      System.out.println();
      System.out.println("Test case 1: default constructor and");
      System.out.println("writeOutput() method.");
      System.out.println();
      Temperature02 t1 = new Temperature02();
      System.out.println("Results of default constructor:");
      System.out.println("Verify 0 degrees C.");
      System.out.println();
      t1.writeOutput();
      System.out.println();
      System.out.println("==========================================");


      System.out.println("Test case 2: readInput() method.");
      t1.readInput();
      System.out.println();
      System.out.println("Verify temperature and units:");
      System.out.println("Should be whatever you just entered.");
      System.out.println();
      t1.writeOutput();
      System.out.println();
      System.out.println("==========================================");


      System.out.println("Test case 3: constructor with just temperature.");
      Temperature02 t2 = new Temperature02(20.5);
      System.out.println();
      System.out.println("Verify 20.5 degrees C.");
      System.out.println();
      t2.writeOutput();
      System.out.println();
      System.out.println("==========================================");


      System.out.println("Test case 4: constructor with just units, f.");
      System.out.println();
      System.out.println("Verify 0 degrees f.");
      System.out.println();
      Temperature02 t3 = new Temperature02('f');
      t3.writeOutput();
      System.out.println();
      System.out.println("==========================================");


      System.out.println("Test case 5: constructor with just units, c.");
      System.out.println();
      System.out.println("Verify 0 degrees c.");
      System.out.println();
      Temperature02 t4 = new Temperature02('c');
      t4.writeOutput();
      System.out.println();
      System.out.println("==========================================");

      System.out.println
	 ("Test case 6: constructor with temperature and units.");
      System.out.println();
      System.out.println("Verify -51.2 degrees F.");
      System.out.println();
      Temperature02 t5 = new Temperature02(-51.2, 'F');
      t5.writeOutput();
      System.out.println();
      System.out.println("==========================================");


      System.out.println();
      System.out.println
	  	("Test case 7: read degrees C, original in F.");
      System.out.println();
      System.out.println("Verify -46.2 degrees Celsius.");
      System.out.println();
      t5.writeC();
      System.out.println();
      System.out.println("==========================================");


      System.out.println();
      System.out.println
	 ("Test case 8: read degrees C, original in C.");
      System.out.println();
      System.out.println("Verify 0 degrees Celsius.");
      System.out.println();
      t4.writeC();
      System.out.println();
      System.out.println("==========================================");


      System.out.println();
      System.out.println
	  	("Test case 9: read degrees F, original in C.");
      System.out.println();
      System.out.println("Verify 32 degrees Fahrenheit");
      System.out.println();
      t4.writeF();
      System.out.println();
      System.out.println("==========================================");


      System.out.println();
      System.out.println
	 ("Test case 10: read degrees F, original in F.");
      System.out.println();
      System.out.println("Verify -51.2 degrees Fahrenheit");
      System.out.println();
      t5.writeF();
      System.out.println();
      System.out.println("Hit enter to continue.");
      System.out.println("==========================================");
 }
}