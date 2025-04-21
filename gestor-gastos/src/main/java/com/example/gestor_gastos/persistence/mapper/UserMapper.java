package com.example.gestor_gastos.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.gestor_gastos.persistence.entity.User;
import com.example.gestor_gastos.persistence.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mappings({
		@Mapping(source = "idUsuario", target = "idUsuarioSpend"),
		@Mapping(source = "nombre", target = "nombreSpend"),
		@Mapping(source = "email", target = "emailSpend"),
		@Mapping(source = "password", target = "passwordSpend")
	})
	User toUser(Usuario usuario);
	
	@InheritInverseConfiguration
	@Mapping(target = "gastos", ignore = true)
	Usuario toUsuario(User user);
}
