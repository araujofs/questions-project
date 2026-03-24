package br.edu.ifpb.pweb2.eureka.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  boolean existsByName(String name);

  Optional<User> findByName(String name);
}
