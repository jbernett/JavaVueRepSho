package com.recipe.backend.Repository;

import java.util.Optional;

import com.recipe.backend.Models.Role;
import com.recipe.backend.Models.Enums.ERole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}