package edu.miu.movie.service.impl;

import edu.miu.movie.dto.MovieFilter;
import edu.miu.movie.entity.Movie;
import edu.miu.movie.service.MovieService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Service
public class MovieServiceImpl implements MovieService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Movie> getMovieByFilter(MovieFilter filter) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Movie.class);
//
//        Root root = criteriaQuery.from(Movie.class);
//        criteriaQuery.select(root);
//        //criteriaQuery
//
//        Query query = entityManager.createQuery(criteriaQuery);
//
//        List results = query.getResultList();

        //return results;
       return null;
    }
}
