package io.microservices.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.microservices.moviecatalogservice.models.CatalogItem;
import io.microservices.moviecatalogservice.models.Movie;
import io.microservices.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired //consumer- tell spring that restTemplate is some where saved and give it here
  private RestTemplate restTemplate;// calling of bean in main code

@RequestMapping("/{userId}")
public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
{
	//Rest Template allow theses object creation of another api in that url 
	//now not needed as bean is created
	//RestTemplate restTemplate = new RestTemplate();//will be called when request comes and get method is called
	
	//get all rated movie IDs
	List<Rating> ratings = Arrays.asList(
			new Rating("1234", 4),
			new Rating("5678", 3)
			);
	//API call for rating data service to get all movies and its ratings using REST Template using for loop or map
	 return ratings.stream().map(rating ->{
		Movie movie= restTemplate.getForObject("http://localhost:8081/movies/"+ rating.getMovieId(),Movie.class);
		return new CatalogItem( movie.getName(),"Desc",rating.getRating());
		 })
	.collect(Collectors.toList());
	
	//For each movie ID, call movie info service and get details
	
	//Put them all together
	
	//return Collections.singletonList(new CatalogItem( "Transformers" , "Test",  4));
}
}

