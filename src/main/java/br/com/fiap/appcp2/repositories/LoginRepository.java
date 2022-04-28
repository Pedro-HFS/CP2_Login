package br.com.fiap.appcp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.appcp2.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

}
