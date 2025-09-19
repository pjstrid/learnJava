package MovieList;

import java.util.ArrayList;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static ArrayList<Movie> movies = new ArrayList<>();

    public static void main(String[] args) {

        initList();

        menu();

    }

    private static void initList(){
        movies.add(new Movie("Forrest Gump", 1994, "Robert Zemeckis", false, 0.0));
        movies.add(new Movie("The Godfather", 1972, "Francis Ford Coppola",false, 0.0));
//        movies.add(new Movie("The Shawshank Redemption", 1994, "Frank Darabont",false, 0.0));
//        movies.add(new Movie("Jaws", 1975, "Steven Spielberg",false, 0.0));
//        movies.add(new Movie("E.T.", 1982, "Steven Spielberg",false, 0.0));
//        movies.add(new Movie("Jurassic Park", 1993, "Steven Spielberg",false, 0.0));
//        movies.add(new Movie("Pulp Fiction", 1994, "Quentin Tarantino",false, 0.0));
//        movies.add(new Movie("Kill Bill: Vol. 1", 2003, "Quentin Tarantino",false, 0.0));
//        movies.add(new Movie("Inglourious Basterds", 2009, "Quentin Tarantino",false, 0.0));
//        movies.add(new Movie("Memento", 2000, "Christopher Nolan",false, 0.0));
//        movies.add(new Movie("Inception", 2010, "Christopher Nolan",false, 0.0));
//        movies.add(new Movie("Oppenheimer", 2023, "Christopher Nolan",false, 0.0));
    }

    private static void menu() {
        boolean isRunning = true;
        System.out.println();
        System.out.println("Welcome to a program about your favourite movies!");

        while (isRunning) {
            // Frågar användaren vad den vill göra med listan.
            System.out.println();
            System.out.println("What do you want to do now?");
            System.out.println("1. Show the list of movies");
            System.out.println("2. Add a movie to the list");
            System.out.println("3. Rate a movie");
            System.out.println("4. Appoint the oldest one between two random selected movies");
            System.out.println("5. Quit");
            System.out.println("Enter your choice: ");
            int choice = InputHandler.getInt(1,5);

            // Rensar scanner
            InputHandler.in.nextLine();

            // Valen för användaren
            switch (choice) {
                case 1 -> printMovieList();     // visar lista
                case 2 -> addMovieToList();
                case 3 -> rateMovie();          // betygsätt film
                case 4 -> compareYearOfMovies();// jämför ålder på två filmer
                case 5 -> isRunning = false;    // avslutar
            }
        }
    }

    private static void printMovieList() {
        System.out.println();
        System.out.println("The list of movies:");
        System.out.println();

        for (Movie m : movies) {
            System.out.println("Title: " + m.getTitle());
            System.out.println("Year: " + m.getYear());
            System.out.println("Director: " + m.getDirector());

            if (m.isRated()){
                System.out.println("Your rating: " + m.getRating());
            } else {
                System.out.println("Your rating: --");
            }
            System.out.println("--------------------------------");
        }
    }

    private static void addMovieToList(){
        System.out.println();
        System.out.println("Add a movie to your list");

        System.out.println("Start with the title:");
        String title = InputHandler.getString();

        System.out.println("And now the year of release:");
        int year = InputHandler.getInt();
        InputHandler.in.nextLine(); // rensar scanner

        System.out.println("And finally the director:");
        String director = InputHandler.getString();

        movies.add(new Movie(title, year, director, false, 0.0)); // default att den inte har något betyg

        System.out.println();
        System.out.println("Adding:");
        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Director: " + director);
    }

    private static void rateMovie(){
        System.out.println();
        System.out.println("Which movie do you want to rate?");
        int i = 1;
        for (Movie m : movies) {
            if (m.isRated()){
                System.out.println(i + ": " + m.getTitle() +" - Already rated: " + m.getRating());
            } else {
                System.out.println(i + ": " + m.getTitle());
            }
            i++;
        }
        System.out.println("Enter your choice:");
        int choice = InputHandler.getInt();

        int j = 1;
        if (choice <= movies.size()) {
            for (Movie m : movies) {
                if (choice == j) {
                    System.out.println("--------------------------------");
                    System.out.println(j + ": " + m.getTitle());
                    System.out.println("Give it a rating:");
                    double ratingToThisMovie = InputHandler.getDouble(0.1, 10.0);
                    m.setRating(ratingToThisMovie);
                    System.out.println("You gave " + m.getTitle() + " the rating: " + m.getRating());
                    System.out.println("--------------------------------");
                    m.setRated(true);
                }
                j++;
            }
        } else {
            System.out.println("Wrong input. Try again");
            rateMovie();
        }
    }

    private static Movie getRandomMovie(){
        Random random = new Random();
        return movies.get(random.nextInt(0, movies.size())); // från noll till listans längd.
    }

    private static void compareYearOfMovies(){
        Movie movie1 = getRandomMovie();
        Movie movie2 = getRandomMovie();

        if (movie1 == movie2) {
            compareYearOfMovies();
        } else if (movie1.getYear() < movie2.getYear()) {
            printMovies(movie1, movie2);
            System.out.println(movie1.getTitle() + ", " + movie1.getYear() + ", is older than "
                    + movie2.getTitle() + ", " + movie2.getYear());
        } else {
            printMovies(movie1, movie2);
            System.out.println(movie2.getTitle() + ", " + movie2.getYear() + ", is older than "
                    + movie1.getTitle() + ", " + movie1.getYear());
        }
    }

    private static void printMovies(Movie movie1, Movie movie2) {
        System.out.println();
        System.out.println("Appointing the oldest one between two random selected movies");
        System.out.println();

        System.out.println("Comparing:");
        System.out.println(movie1.getTitle());
        System.out.println();

        System.out.println("With:");
        System.out.println(movie2.getTitle());
        System.out.println();


    }
}