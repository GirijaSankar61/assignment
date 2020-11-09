package com.example.repository;

import com.example.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class MovieRepository {

  @Autowired private JdbcTemplate template;

  @PostConstruct
  public void createTable() {
    template.execute(
        "CREATE TABLE movies (id bigint auto_increment primary key, name VARCHAR(50), year int, rating int)");
  }

  public void createMovie(String name, int year, int rating) {

    template.update(
            "insert into movies (name, year,rating) values(?,?,?)",
            name, year,rating);
  }

  public List<Movie> findMoviesByName(String likeName) {
    List<Movie> movies =
        template.query(
            "SELECT * from  movies where name like ? ",
                new Object[]{likeName},
            (rs, rowNum) ->
                new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("year"),
                    rs.getInt("rating")));
    return movies;
  }
}
