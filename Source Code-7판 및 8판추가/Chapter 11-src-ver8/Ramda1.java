public class Ramda1 {
Person rin = new Person();
rin.hi((a,b) ->{
	System.out.println("This is Coding-Factory!");
	System.out.println("Tank you Lamda");
	System.out.println("parameter number is "+a+","+b);
    return 7;
});
}