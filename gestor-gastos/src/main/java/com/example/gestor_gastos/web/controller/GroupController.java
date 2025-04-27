package com.example.gestor_gastos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestor_gastos.domain.service.GroupService;
import com.example.gestor_gastos.persistence.entity.Group;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/group")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	 @Operation(
		        summary = "Obtener todos los grupos",
		        description = "Devuelve una lista de todos los grupos registrados."
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "Lista de grupos encontrada"),
		        @ApiResponse(responseCode = "500", description = "Error interno")
		    })
	@GetMapping("/all")
	public ResponseEntity<List<Group>> getAll() {
		return new ResponseEntity<>(groupService.getAll(), HttpStatus.OK);
	}

	 @Operation(
		        summary = "Obtener un grupo por el nombre",
		        description = "Devuelve una lista de todos los grupos a partir del nombre."
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "Lista de grupos encontrada"),
		        @ApiResponse(responseCode = "404", description = "Grupo no encontrado")
		    })
	@GetMapping("/{nameGroup}")
	public ResponseEntity<List<Group>> getByNameGroup(@PathVariable("nameGroup") String nameGroup) {
		return groupService.getByNameGroup(nameGroup)
				.map(group -> new ResponseEntity<>(group, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	 @Operation(
		        summary = "Guardar grupos",
		        description = "Guarda los datos correspondientes a los datos introducidos en el grupo."
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "Lista de grupos guardada"),
		        @ApiResponse(responseCode = "404", description = "Grupo no guardado")
		    })
	@PostMapping("/save")
	public ResponseEntity<Group> save(@RequestBody Group group) {
		return new ResponseEntity<>(groupService.save(group), HttpStatus.CREATED);
	}


}
