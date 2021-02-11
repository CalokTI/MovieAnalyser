package exercise.services;

import exercise.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Carsten
 * Time: 13.37
 * Date: 11/02/2021
 */
public class MovieAnalysisService {

    private ArrayList<Movie> moviesList = new ArrayList<>();
    private ArrayList<Integer> nums = new ArrayList<>();

     public MovieAnalysisService (){
        createMovieArrayList();
        createNumsArrayList();
    }

    public void createNumsArrayList(){
        int j = moviesList.size();
        for (int i = 0; i < j; i++) {
            nums.add(i);
        }
    }

    public void createMovieArrayList(){
        File movieList = new File("src/main/resources/static/film-new.csv");
        Movie movie;
        try {
            Scanner sc = new Scanner(movieList);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] firstMovieAsArray = sc.nextLine().split(";");
                movie = new Movie(firstMovieAsArray[0], firstMovieAsArray[1], firstMovieAsArray[2], firstMovieAsArray[3], Integer.parseInt(firstMovieAsArray[4]), firstMovieAsArray[5]);
                moviesList.add(movie);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("no file found");
        }
    }

    public Movie getFirstMovie(){
        return moviesList.get(0);
    }

    public ArrayList<Movie> getRandomMovies(int amount){
        Collections.shuffle(nums);
        ArrayList<Movie> randomMovies = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            randomMovies.add(moviesList.get(nums.get(i)));
        }

        return randomMovies;
    }

    public ArrayList<Movie> getRandomMoviesSortedByPopularity(int amount){
        ArrayList<Movie> randomMovies = getRandomMovies(amount);
        Collections.sort(randomMovies);
        return randomMovies;
    }

    public int getAmountOfMoviesWithAwards(){
        int count = 0;
        for (int i = 0; i < moviesList.size(); i++) {
            if (moviesList.get(i).isWonAward()){
                count++;
            }
        }
        return count;
    }


}
