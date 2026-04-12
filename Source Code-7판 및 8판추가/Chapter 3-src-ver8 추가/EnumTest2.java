
public class EnumTest2
{
	enum MovieRating {E, A, B}
    public static void main(String[] args)
    {

        MovieRating[] arr = MovieRating.values();
        for (MovieRating rating : arr) {

        switch (rating)
        {
			case E: //Excellent
					System.out.println("1).You must see this movie!");
					break;
			case A: //Average
					System.out.println("2).THis movie is OK, but not great.");
					break;
			case B: //Bad
					System.out.println("3).Skip it!");
					break;
			default:
					System.out.println("SOmething is wrong");
	    }
	}
	}
}

