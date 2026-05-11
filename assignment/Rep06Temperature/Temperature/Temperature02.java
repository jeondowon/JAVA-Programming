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