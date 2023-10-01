package dev.tut.movies.services;
import dev.tut.movies.enteties.Movie;
import dev.tut.movies.enteties.Review;
import dev.tut.movies.repositories.MovieRepository;
import dev.tut.movies.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

//    public void reviewMovie(String reviewBody, String imdbId){
//        Optional<Movie> optionalMovie = movieRepository.findByImdbId(imdbId);
//        Review review =reviewRepository.insert(new Review(reviewBody)) ;
//
//        if (optionalMovie.isPresent()){
//            Movie movie= optionalMovie.get();
//            movie.getReviewsId().add(review);
//            movieRepository.save(movie);
//
//        }
//
//    }
    @Autowired
    MongoTemplate mongoTemplate;
    public void reviewMovie(String reviewBody,String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewsId").value(review))
                .first();
    }
}
