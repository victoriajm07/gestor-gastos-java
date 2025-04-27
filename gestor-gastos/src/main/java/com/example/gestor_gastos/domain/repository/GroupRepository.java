package com.example.gestor_gastos.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.gestor_gastos.persistence.entity.Group;

public interface GroupRepository {

	List<Group> getAll();
	Optional<List<Group>> getByNameGroup(String nameGroup);
	Group save(Group group);
}
