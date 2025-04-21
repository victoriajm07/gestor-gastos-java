package com.example.gestor_gastos.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.gestor_gastos.persistence.entity.Gasto;
import com.example.gestor_gastos.persistence.entity.Spend;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface SpendMapper {

	@Mappings({
		@Mapping(source = "idGasto", target = "idGastoSpend"),
		@Mapping(source = "monto", target = "montoSpend"),
		@Mapping(source = "fecha", target = "fechaSpend"),
		@Mapping(source = "tipo", target = "tipoSpend"),
		@Mapping(source = "usuario", target = "user"),
		@Mapping(target = "idUsuarioSpend", ignore = true)
	})
	Spend toSpend(Gasto gasto);
	
	List<Spend> toSpends(List<Gasto> gastos);
	
	@InheritInverseConfiguration
	@Mapping(target = "categoria", ignore = true)
	Gasto toGasto(Spend spend);
}
