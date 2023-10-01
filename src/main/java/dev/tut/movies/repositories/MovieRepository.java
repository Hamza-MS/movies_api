package dev.tut.movies.repositories;

import dev.tut.movies.enteties.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findByTitle(String name);

    Optional<Movie> findByImdbId(String imdbId);
}
