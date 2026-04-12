
public class EnumTest
{
	enum MovieRating {E, A, B}
    public static void main(String[] args)
    {

        MovieRating rating;
        rating = MovieRating.A;
        switch (rating)
        {
			case E: //Excellent
					System.out.println("You must see this movie!");
					break;
			case A: //Average
					System.out.println("THis movie is OK, but not great.");
					break;
			case B: //Bad
					System.out.println("Skip it!");
					break;
			default:
					System.out.println("SOmething is wrong");
	    }
	}
}

