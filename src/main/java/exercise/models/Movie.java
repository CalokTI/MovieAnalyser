package exercise.models;

/**
 * @author Carsten
 * Time: 13.35
 * Date: 11/02/2021
 */
public class Movie implements Comparable<Movie> {

    private String year;
    private String length;
    private String title;
    private String subject;
    private int popularity;
    private boolean wonAward;


    public Movie(String year, String length, String title, String subject, int popularity, String wonAward) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;

        if (wonAward.equalsIgnoreCase("Yes")) {
            this.wonAward = true;
        }
        else {
            this.wonAward = false;
        }
    }

    public String getTitle() {
        return title;
    }

    public int getPopularity() {
        return popularity;
    }

    public boolean isWonAward() {
        return wonAward;
    }

    @Override
    public int compareTo(Movie movie){
        return Integer.compare(getPopularity(), movie.getPopularity());
    }
}
