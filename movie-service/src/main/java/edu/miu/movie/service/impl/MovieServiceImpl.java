package edu.miu.movie.service.impl;
import edu.miu.movie.dto.MovieDTO;
import edu.miu.movie.dto.MovieFilter;
import edu.miu.movie.entity.Movie;
import edu.miu.movie.repository.MovieRepository;
import edu.miu.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;


    @Override
    public List<Movie> getMovieByFilter(MovieFilter filter) {
       return repository.findAllMovieByFilter(filter);
    }

    @Override
    public List<Movie> getAllMovies() {

        return repository.findAll();
    }

    @Override
    public Movie getOneMovie(Long id) {
        Movie movie=repository.findById(id).get();
        log.info("-===> movie: {}", movie);
        return movie;
    }

    @Override
    public Movie addMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        log.info("-===> dto: {}", movieDTO);
        BeanUtils.copyProperties(movieDTO, movie, "id");
        movie = repository.save(movie);
        return movie;
    }

    @Override
    public void deleteMovie(Long id) {
      repository.deleteById(id);

    }


    @Override
    public Movie editMovie(Long id,MovieDTO movieDTO) {
       Movie movie=repository.findById(id).get();
       movie.setActor(movieDTO.getActor());
       movie.setGenre(movieDTO.getGenre());
       movie.setDirector(movieDTO.getDirector());
       movie.setDuration(movieDTO.getDuration());
        repository.save(movie);
        return movie;

    }


}
