package edu.miu.userservice.repository;

import edu.miu.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
