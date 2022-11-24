package edu.miu.userservice.repository;

import edu.miu.userservice.entity.FavoriteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@Repository
public interface FavoriteListRepository extends JpaRepository<FavoriteList, Long> {
}
