package edu.miu.movie.repository;

import edu.miu.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
