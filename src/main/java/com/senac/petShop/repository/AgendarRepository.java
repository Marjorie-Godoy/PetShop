
package com.senac.petShop.repository;

import com.senac.petShop.model.Agendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendarRepository extends JpaRepository<Agendar, Integer>{
    
}
