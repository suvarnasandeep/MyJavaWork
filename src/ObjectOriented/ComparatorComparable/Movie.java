package ComparatorComparable;


public class Movie implements Comparable<Movie>{

	String name;
	int year;
	int rating;
	
	public Movie(String name, int year, int rating) {
		this.name = name;
		this.year = year;
		this.rating = rating;
	}
	
	@Override
	public int compareTo(Movie o) {
		//return this.year-o.year;
		return this.name.compareTo(o.name);
	}
	
	 public String getName () {
			return name;
		}
		 
		 public int getYear() {
			return year;
		}
		 
		 public int getRating() {
			return rating;
		}

}
