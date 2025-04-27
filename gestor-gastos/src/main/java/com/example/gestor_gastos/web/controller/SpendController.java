package com.example.gestor_gastos.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestor_gastos.domain.service.SpendService;
import com.example.gestor_gastos.persistence.entity.Spend;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/spend")
@Tag(name = "Gastos", description = "Operaciones relacionadas con los gastos")
public class SpendController {

	@Autowired
	private SpendService spendService;
	
	 @Operation(
		        summary = "Obtener todos los gastos",
		        description = "Devuelve una lista de todos los gastos registrados."
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "Lista de gastos encontrada"),
		        @ApiResponse(responseCode = "500", description = "Error interno")
		    })
	@GetMapping("/all")
	public ResponseEntity<List<Spend>> getAll() {
		return new ResponseEntity<>(spendService.getAll(), HttpStatus.OK);
	}
	
	 @Operation(
		        summary = "Obtener un gasto por ID",
		        description = "Devuelve un gasto específico a partir de su ID."
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "Gasto encontrado"),
		        @ApiResponse(responseCode = "404", description = "Gasto no encontrado")
		    })
	@GetMapping("/{idGastoSpend}")
	public ResponseEntity<Spend> getSpend(@PathVariable("idGastoSpend") Integer idGastoSpend) {
		return spendService.getSpend(idGastoSpend)
				.map(spend -> new ResponseEntity<>(spend, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	 @Operation(
		        summary = "Obtener un gasto por el ID del usuario",
		        description = "Devuelve un gasto específico a partir de su ID."
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
		        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
		    })
	@GetMapping("/{idUsuarioSpend}")
	public ResponseEntity<List<Spend>> getByUser(@PathVariable("idUsuarioSpend") Integer idUsuarioSpend) {
		return spendService.getByUser(idUsuarioSpend)
				.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	 @Operation(
		        summary = "Guardar",
		        description = "Guardar un gasto."
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "Gasto guardado"),
		        @ApiResponse(responseCode = "404", description = "Gasto no guardado")
		    })
	@PostMapping("/save")
	public ResponseEntity<Spend> save(@RequestBody Spend spend) {
		return new ResponseEntity<>(spendService.save(spend), HttpStatus.CREATED);
	}
	
	 @Operation(
		        summary = "Eliminar",
		        description = "Elimina un gasto específico a partir de su ID."
		    )
		    @ApiResponses({
		        @ApiResponse(responseCode = "200", description = "Gasto eliminado"),
		        @ApiResponse(responseCode = "404", description = "Gasto no eliminado")
		    })
	@DeleteMapping("/delete/{idGastoSpend}")
	public ResponseEntity delete(@PathVariable("idGastoSpend") Integer idGastoSpend) {
		if (spendService.delete(idGastoSpend)) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
