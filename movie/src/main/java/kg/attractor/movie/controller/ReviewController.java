package kg.attractor.movie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("reviews")
public class ReviewController {

    @GetMapping("by_movie_id")
    public void getByMovieId(@RequestParam("movie_id") Long movie_id){
        System.out.println("getByMovieId" + movie_id);
    }
}
