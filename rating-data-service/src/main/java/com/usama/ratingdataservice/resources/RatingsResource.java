package com.usama.ratingdataservice.resources;

import com.usama.ratingdataservice.models.Rating;
import com.usama.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingsResource {

    @RequestMapping("movies/{movieId}")
    public Rating getRating(@PathVariable String movieId){
        return new Rating(movieId,4.0f);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable String userId){
        UserRating userRating = new UserRating();
        List<Rating> ratings = Arrays.asList(
                new Rating("100", 4.0f),
                new Rating("102",3.0f),
                new Rating("103",3.8f)
        );
        userRating.setUserRating(ratings);
        return userRating;
    }
}
