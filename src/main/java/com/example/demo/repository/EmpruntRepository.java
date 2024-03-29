package com.example.demo.repository;

import com.example.demo.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {

    List<Emprunt> findByAdherent_IdAndIsOngoing(Integer id, Boolean isOngoing);
}