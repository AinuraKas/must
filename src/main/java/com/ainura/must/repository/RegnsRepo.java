package com.ainura.must.repository;

import com.ainura.must.domain.Regns;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegnsRepo extends JpaRepository<Regns,Long> {
    List<Regns> findFirstByRegnsid(Integer id);

}
