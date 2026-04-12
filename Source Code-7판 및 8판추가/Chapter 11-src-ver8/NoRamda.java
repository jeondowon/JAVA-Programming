public class NoRamda {

Person rin = new Person();
rin.hi(new Say() {
    public int someting(int a, int b) {
	System.out.println("My Name is Coding-Factory");
	System.out.println("Nice to meet you");
	System.out.println("parameter number is "+a+","+b);
	return 7;
    }
});


}