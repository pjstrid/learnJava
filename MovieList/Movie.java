package MovieList;
public class Movie {

    // Properties

    private String title;

    private int year;

    private String director; // för och efternamn

    private double rating;

    private boolean rated;


    // Constructure

    public Movie(String title, int year, String director, boolean rated, double rating) { // five different attributes
        this.title = title;
        this.year = year;
        this.director = director;
        this.rated = rated;
        this.rating = rating;
    }

    // Setters and Getters

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }

    public boolean isRated() {
        return rated;
    }
}

