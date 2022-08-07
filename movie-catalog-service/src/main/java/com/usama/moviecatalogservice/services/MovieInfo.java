package com.usama.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.usama.moviecatalogservice.models.MovieSummary;
import com.usama.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackMovieSummary",

            threadPoolKey = "movieInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )
    public MovieSummary getMovieSummary(Rating rating) {
        MovieSummary movieSummary = restTemplate.getForObject("http://movie-info-service/api/movies/" + rating.getMovieId(), MovieSummary.class);
        return movieSummary;
    }

    public MovieSummary getFallbackMovieSummary(Rating rating) {
        return new MovieSummary(
                "Not Found",
                "Not Found",
                "Movie name not found",
                "Not Found",
                "Not Found",
                "Not Found",
                "Not Found",
                "Not Found",
                "Not Found",
                "Not Found",
                Float.toString(rating.getRating())
        );
    }
}
