package com.bsuir.course.repository;

import com.bsuir.course.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
     User findOneByEmail(String username);


     boolean existsByEmail(String email);

     Iterable<User> findByRolesName(String id);

     @Modifying
     @Transactional
     @Query("delete from User where email = :UserEmail")
     void deleteUsersByUserEmail(@Param("UserEmail") String UserEmail);
}
