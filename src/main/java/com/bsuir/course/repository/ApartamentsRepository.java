package com.bsuir.course.repository;

import com.bsuir.course.domain.Apartaments;
import com.bsuir.course.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ApartamentsRepository extends JpaRepository<Apartaments,Long> {

    List<Apartaments> findAllByUser(User user);

    List<Apartaments> findAllByType(String type);

    Apartaments findApartamentsById(Long id);

    void deleteApartamentsByUser(User user);
}
