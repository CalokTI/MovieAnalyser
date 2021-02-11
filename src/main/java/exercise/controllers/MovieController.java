package exercise.controllers;

import exercise.models.Movie;
import exercise.services.MovieAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author Carsten
 * Time: 12.55
 * Date: 11/02/2021
 */
@Controller
public class MovieController {

    MovieAnalysisService movieAnalysisService = new MovieAnalysisService();

    //3.1 / - Description & nice message
    @ResponseBody
    @GetMapping("/")
    public String movie(){
        return "<h1>MovieAnalyser</h1><br>Hello local user?<br>Follow one of the links below for the information you seek.<br>" +
                "<a href=\"http://localhost:8080/getFirst\">Show the first movie on the list</a><br> " +
                "<a href=\"http://localhost:8080/getRandom\">Show 10 random movies</a><br> " +
                "<a href=\"http://localhost:8080/getTenSortByPopularity\">Show 10 random movies sorted by popularity</a><br> " +
                "<a href=\"http://localhost:8080/howManyWonAnAward\">Show how many movies from the list won an award</a> ";
    }

    //3.2 /getFirst - display first movie title
    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst(){
        return "<h1>First movie on the list</h1><br>" + movieAnalysisService.getFirstMovie().getTitle();
    }

    //3.3 /getRandom - single random movie, display title
    @ResponseBody
    @GetMapping("/getRandom")
    public String getRandom(){
        ArrayList<Movie> randomMovies = movieAnalysisService.getRandomMovies(10);
        String str ="<h1>10 random movies</h1><br>";
        for (int i = 0; i < randomMovies.size(); i++) {
            str += randomMovies.get(i).getTitle() + "<br>";
        }
        return str;
    }

    //3.4 /getTenSortByPopularity - 10 random movies, added to arraylist and sorted by popularity
    @ResponseBody
    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity(){
        ArrayList<Movie> sortedMovies = movieAnalysisService.getRandomMoviesSortedByPopularity(10);
        String str = "<h1>10 random movies sorted by popularity</h1><br>";
        for (int i = 0; i < sortedMovies.size(); i++) {
            str += sortedMovies.get(i).getTitle() +" " +  sortedMovies.get(i).getPopularity() + "<br>";
        }
        return str;
    }

    //3.5 /howManyWonAnAward - print amount of movies with an award
    @ResponseBody
    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward(){

        return "<h1>Amount of movies which has won an award</h1><br>" + movieAnalysisService.getAmountOfMoviesWithAwards();
    }


}
