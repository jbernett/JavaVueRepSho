package com.recipe.backend.Models;

import javax.persistence.*;
import com.recipe.backend.Models.Enums.ERole;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "ROLES")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "NAME", length = 20)
	private ERole name;

}