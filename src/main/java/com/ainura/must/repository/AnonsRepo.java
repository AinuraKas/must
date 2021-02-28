package com.ainura.must.repository;

import com.ainura.must.domain.Anons;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnonsRepo extends CrudRepository<Anons,Integer> {
    List<Anons> findByTextStartingWith(String fr);
    List<Anons>findByAnonsid(Integer id);
}
