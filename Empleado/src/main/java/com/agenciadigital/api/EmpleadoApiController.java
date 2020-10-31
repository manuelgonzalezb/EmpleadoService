package com.agenciadigital.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import com.agenciadigital.api.service.EmpleadoServices;
import com.agenciadigital.service.domain.Empleado;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-31T09:17:10.375-05:00[America/Bogota]")

@RestController
@RequestMapping("${openapi.empleados.base-path:/agenciadigital}")
public class EmpleadoApiController implements IEmpleadoApi {

	private final NativeWebRequest request;

	@Autowired
    private EmpleadoServices empleadoService;

	@org.springframework.beans.factory.annotation.Autowired
	public EmpleadoApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@ApiOperation(value = "Registrar un nuevo empleado", nickname = "empleadoPST", notes = "Crea el empleado de acuerdo con los parámetros recibidos.", response = Empleado.class, tags = {
			"Empleado", })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Empleado registrado exitosamente", response = Empleado.class),
			@ApiResponse(code = 400, message = "Parametro Invalido"),
			@ApiResponse(code = 409, message = "Error de negocio"),
			@ApiResponse(code = 500, message = "Error del sistema") })
	@RequestMapping(value = "/empleado", produces = { "application/json","application/xml" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Empleado> empleadoPST(
			@ApiParam(value = "Empleado a registrar") @Valid @RequestBody Empleado empleado) throws RuntimeException{
		Empleado empleadoResponse = empleadoService.createEmpleado(empleado);
		return new ResponseEntity<Empleado>(empleadoResponse, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Consulta al información de los empleados basado en parámetros de búsqueda", nickname = "empleadosGETAll", notes = "Consulta al información de los empleados basado en parámetros de búsqueda ", response = Empleado.class, tags = {
			"Empleado", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Consulta exitosa", response = Empleado.class),
			@ApiResponse(code = 400, message = "Parametro invalido"),
			@ApiResponse(code = 500, message = "Error del sistema"),
			@ApiResponse(code = 401, message = "No autorizado") })
	@RequestMapping(value = "/empleado", produces = { "application/json","application/xml" }, method = RequestMethod.GET)
	public List<Empleado> empleadosGETAll( @RequestParam(required = false, value = "fechaInicio") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime fechaInicio, @RequestParam(required = false, value = "fechaFin") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime fechaFin) {
		List<Empleado> empleados = new ArrayList<>();
		empleados=empleadoService.getAllEmpleados(fechaInicio, fechaFin);
		return empleados;
	}

    @ApiOperation(value = "Consulta al información de un empleado por su id", nickname = "empleadoGETById", notes = "Consulta al información de un empleado por su id ", response = Empleado.class, tags = {
            "Empleado", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Consulta exitosa", response = Empleado.class),
            @ApiResponse(code = 400, message = "Parametro invalido"),
            @ApiResponse(code = 500, message = "Error del sistema"),
            @ApiResponse(code = 401, message = "No autorizado") })
    @RequestMapping(value = "/empleado/{id}", produces = { "application/json","application/xml" }, method = RequestMethod.GET)
    public Empleado empleadoGETById(
            @ApiParam(value = "Id de empleado", required = true) @PathVariable("id") int id) {
        Empleado empleado = empleadoService.getById(id);
		return empleado;

    }
	
	@ApiOperation(value = "Actualizar información del empleado", nickname = "empleadoPCT", notes = "Actualiza el empleado de acuerdo con los parámetros recibidos.", response = Empleado.class, tags={ "Empleado", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Empleado actualizado exitosamente", response = Empleado.class),
        @ApiResponse(code = 400, message = "Parametro Invalido"),
        @ApiResponse(code = 500, message = "Error del sistema") })
    @RequestMapping(value = "/empleado/{id}",
        produces = { "application/json","application/xml" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    public ResponseEntity<Empleado> empleadoPCT(@ApiParam(value = "Id de empleado", required = true) @PathVariable("id") int id, @ApiParam(value = "Empleado a actualizar"  )  @Valid @RequestBody Empleado empleado) {
		empleadoService.updateEmpleado(empleado,id);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
	
	
	@ApiOperation(value = "Borrar el empleado por su id", nickname = "empleadoDEL", notes = "Borra el empleado de acuerdo al id recibido.", tags={ "Empleado", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Empleado borrado exitosamente"),
        @ApiResponse(code = 400, message = "Parametro Invalido"),
        @ApiResponse(code = 500, message = "Error del sistema") })
    @RequestMapping(value = "/empleado/{id}",
        method = RequestMethod.DELETE)
    public ResponseEntity<Void> empleadoDEL(@ApiParam(value = "Id de empleado",required=true) @PathVariable("id") int id) {
        empleadoService.deleteCliente(id);
		return new ResponseEntity<>(HttpStatus.CREATED);

    }


}
