package org.test.spring.data.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.test.spring.data.entity.Client;

import java.util.List;

/**
 * Created by a203696 on 07/07/2014.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNomLike(String nom);
    List<Client> findByNomLikeAndPrenom(String nom, String prenom);

    List<Client> findByName(@Param("name") String name);
}
