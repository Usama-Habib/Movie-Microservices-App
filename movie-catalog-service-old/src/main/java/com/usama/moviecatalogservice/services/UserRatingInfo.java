package com.usama.moviecatalogservice.services;

import com.usama.moviecatalogservice.models.Rating;
import com.usama.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {

//    @Autowired
//    private RestTemplate restTemplate;
//
////       @HystrixCommand(fallbackMethod = "getFallbackUserRating")
//    public UserRating getUserRating(String userId) {
//        return restTemplate.getForObject("http://rating-data-service/api/ratings/users/" + userId, UserRating.class);
//    }
//
//    public UserRating getFallbackUserRating(String userId) {
//        UserRating userRating = new UserRating();
//        userRating.setUserRating(Arrays.asList(
//                new Rating("0",0.0f)
//        ));
//        return userRating;
//    }
}
