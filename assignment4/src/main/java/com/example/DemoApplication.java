package com.example;

import com.example.config.Config;
import com.example.domain.Movie;
import com.example.repository.MovieRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
    config.register(Config.class);
    config.refresh();
    MovieRepository repository = config.getBean(MovieRepository.class);

    repository.createMovie("Some movie", 1974, 3);
    repository.createMovie("Some other movie", 1993, 2);

    List<Movie> movies = repository.findMoviesByName("Some%");
    for (Movie movie : movies) {
      System.out.println(movie.name + " - " + movie.year + " - " + movie.rating);
    }
  }
}
