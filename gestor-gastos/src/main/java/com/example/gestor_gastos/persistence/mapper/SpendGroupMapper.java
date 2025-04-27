package com.example.gestor_gastos.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.gestor_gastos.persistence.entity.GastoGrupo;
import com.example.gestor_gastos.persistence.entity.SpendGroup;

@Mapper(componentModel = "spring")
public interface SpendGroupMapper {
	
	@Mappings({
		@Mapping(source = "idGastoGrupo", target = "idSpendGroup"),
		@Mapping(source = "grupo", target = "group"),
		@Mapping(source = "monto", target = "amount"),
		@Mapping(source = "fecha", target = "date"),
		@Mapping(source = "categoría", target = "category")
	})
	SpendGroup toSpendGroup(GastoGrupo gastoGrupo);
	
	@InheritInverseConfiguration
	@Mapping(target = "distribuciones", ignore = true)
	GastoGrupo toGastoGrupo(SpendGroup spendGroup);

}
