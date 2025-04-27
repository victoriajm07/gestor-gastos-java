package com.example.gestor_gastos.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestor_gastos.domain.repository.GroupRepository;
import com.example.gestor_gastos.persistence.entity.Group;

@Service
public class GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	
	public List<Group> getAll() {
		return groupRepository.getAll();
	}


	public Group save(Group group) {
		return groupRepository.save(group);
	}


	public Optional<List<Group>> getByNameGroup(String nameGroup) {
		return groupRepository.getByNameGroup(nameGroup);
	}

}
