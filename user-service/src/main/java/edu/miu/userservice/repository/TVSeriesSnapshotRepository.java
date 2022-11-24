package edu.miu.userservice.repository;

import edu.miu.userservice.entity.TVSeriesSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@Repository
public interface TVSeriesSnapshotRepository extends JpaRepository<TVSeriesSnapshot, Long> {
}
