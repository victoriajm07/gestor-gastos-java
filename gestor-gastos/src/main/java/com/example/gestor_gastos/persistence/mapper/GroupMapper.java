package com.example.gestor_gastos.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.gestor_gastos.persistence.entity.Group;
import com.example.gestor_gastos.persistence.entity.Grupo;

@Mapper(componentModel = "spring", uses = {SpendGroupMapper.class})
public interface GroupMapper {
	
	@Mappings({
		@Mapping(source = "idGrupo", target = "idGroup"),
		@Mapping(source = "nombreGrupo", target = "nameGroup"),
		@Mapping(source = "descripcion", target = "description")
	})
	Group toGroup(Grupo grupo);
	
	List<Group> toGroups(List<Grupo> grupos);
	
	@InheritInverseConfiguration
	@Mappings({
		@Mapping(target = "miembroGrupos", ignore = true),
		@Mapping(target = "gastosGrupo", ignore = true)
	})
	Grupo toGrupo(Group group);
}
