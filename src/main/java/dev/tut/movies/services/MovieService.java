package dev.tut.movies.services;

import dev.tut.movies.enteties.Movie;
import dev.tut.movies.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }



    public Optional<Movie> movieByName(String name){
        return movieRepository.findByTitle(name);
    }
}
