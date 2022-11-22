package edu.miu.movie.repository.impl;

import edu.miu.movie.dto.MovieFilter;
import edu.miu.movie.entity.Movie;
import edu.miu.movie.repository.CustomMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Repository
@RequiredArgsConstructor
public class CustomMovieRepositoryImpl implements CustomMovieRepository {

    private final EntityManager entityManager;

    @Override
    public List<Movie> findAllMovieByFilter(MovieFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);

        Root<Movie> movie = cq.from(Movie.class);
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(filter.getActor())) {
            predicates.add(cb.equal(movie.get("actor"), filter.getActor()));
        }
        if (StringUtils.hasText(filter.getDirector())) {
            predicates.add(cb.equal(movie.get("director"), filter.getDirector()));
        }
        if (StringUtils.hasText(filter.getGenre())) {
            predicates.add(cb.equal(movie.get("genre"), filter.getGenre()));
        }
        if (!Objects.isNull(filter.getReleaseYear())) {
            predicates.add(cb.equal(movie.get("releaseYear"), filter.getReleaseYear()));
        }
        if (!Objects.isNull(filter.getRating())) {
            predicates.add(cb.equal(movie.get("rating"), filter.getRating()));
        }
        if (!Objects.isNull(filter.getDuration())) {
            predicates.add(cb.equal(movie.get("duration"), filter.getDuration()));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
