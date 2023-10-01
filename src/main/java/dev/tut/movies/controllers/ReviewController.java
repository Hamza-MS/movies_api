package dev.tut.movies.controllers;

import dev.tut.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public void createReviewForMovie(@RequestBody Map<String,String> payLoad){
        reviewService.reviewMovie(payLoad.get("reviewBody"),payLoad.get("imdbId"));
    }
}
