package edu.miu.tvseries.controller;

import edu.miu.tvseries.controller.dto.MovieFilter;
import edu.miu.tvseries.controller.dto.TVSeriesDTO;
import edu.miu.tvseries.entity.TVSeries;
import edu.miu.tvseries.service.TVSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/v1/tvseries")
@RequiredArgsConstructor
public class TVSeriesController {

    private final TVSeriesService tvSeriesService;

    @GetMapping("/filter")
    public List<TVSeries> getAllMovieByFilter(MovieFilter filter) {
        return tvSeriesService.getTVSeriesByFilter(filter);
    }


    @PostMapping
    public TVSeries addMovie(@RequestBody TVSeriesDTO tvSeriesDTO){
        return tvSeriesService.addTVSeries(tvSeriesDTO);
    }

    @GetMapping()
    public List<TVSeries> getAllMovies(){
        return tvSeriesService.getAllTVSeries();
    }

    @GetMapping("/{id}")
    public TVSeries getOneMovie(@PathVariable Long id){
        return tvSeriesService.getOneTVSeries(id);
    }

    @PutMapping("/{id}")

    public TVSeries editMovie(@PathVariable Long id, @RequestBody TVSeriesDTO tvSeriesDTO){
        return tvSeriesService.editTVSeries(id,tvSeriesDTO);
    }
}
