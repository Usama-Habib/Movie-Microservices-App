package com.usama.moviecatalogservice.resource;

import com.usama.moviecatalogservice.models.*;
import com.usama.moviecatalogservice.services.MovieInfo;
import com.usama.moviecatalogservice.services.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/catalogs")
public class MovieCatalogResource {

    @Autowired
    private DiscoveryClient discoveryClient;

//    @Autowired
//    RestTemplate restTemplate;
//
//    @Autowired
//    MovieInfo movieInfo;
//
//    @Autowired
//    UserRatingInfo userRatingInfo;

//    @RequestMapping("/{userId}")
//    public List<MovieSummary> getCatalog(@PathVariable String userId){
//
//        // First get List of rated movies
//        UserRating userRating = userRatingInfo.getUserRating(userId);
//
//        // Make call to Movie Service to get movie details
//        // Put them all together
//
//        return userRating.getUserRating().stream().map(rating -> movieInfo.getMovieSummary(rating))
//        .collect(Collectors.toList());
//    }

    @RequestMapping(value = "/discover/{serviceId}")
    public Map<String, Object> discoverClientInfo(@PathVariable String serviceId){
        Map<String,Object> discoveryMap = new HashMap<>();
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            for (ServiceInstance serviceInstance: instances){
                discoveryMap.put("Instance ID",serviceInstance.getInstanceId());
                discoveryMap.put("Service ID",serviceInstance.getServiceId());
                discoveryMap.put("Host",serviceInstance.getHost());
                discoveryMap.put("Port",serviceInstance.getPort());
                discoveryMap.put("URI",serviceInstance.getUri());
            }
            return discoveryMap;
    }
}



//    @Autowired
//     WebClient.Builder builder;

//            Movie movie = builder.build()
//                            .get()
//                            .uri("http://localhost:8081/api/movies/"+rating.getMovieId())
//                            .retrieve()
//                            .bodyToMono(Movie.class)
//                            .block();

