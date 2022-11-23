package edu.miu.tvseries.repository;


import edu.miu.tvseries.entity.TVSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Repository
public interface TVSeriesRepository extends JpaRepository<TVSeries, Long>, CustomTVSeriesRepository {

}
