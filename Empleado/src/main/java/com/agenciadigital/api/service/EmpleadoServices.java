package com.agenciadigital.api.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.agenciadigital.api.repository.EmpleadoEntity;
import com.agenciadigital.api.repository.EmpleadoRepository;
import com.agenciadigital.service.domain.Empleado;
import com.agenciadigital.service.domain.EmpleadoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpleadoServices {
	private final EmpleadoRepository empleadoRepository;

	@Autowired
	EmpleadoServices(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}

	public Empleado createEmpleado(Empleado empleado) throws EmpleadoException {
		try {

			EmpleadoEntity empleadoEntity = new EmpleadoEntity();

			if (empleado.getIdentificacion() != null) {
				empleadoEntity.setIdentificacion(empleado.getIdentificacion());

			} else {
				throw new EmpleadoException("La identificacion es obligatoria");
			}

			if (empleado.getTipoIdentificacion() != null) {
				empleadoEntity.setTipoIdentificacion(empleado.getTipoIdentificacion());
			} else {
				throw new EmpleadoException("El tipo de identificacion del empleado es obligatoria");
			}
			if (empleado.getTipoIdentificacion() != null) {
				empleadoEntity.setTipoIdentificacion(empleado.getTipoIdentificacion());
			} else {
				throw new EmpleadoException("El tipo de identificacion del empleado es obligatoria");
			}
			if (empleado.getNombres() != null) {
				empleadoEntity.setNombres(empleado.getNombres());
			} else {
				throw new EmpleadoException("Los nombres son obligatoria");
			}
			if (empleado.getApellidos() != null) {
				empleadoEntity.setApellidos(empleado.getApellidos());
			} else {
				throw new EmpleadoException("Los apellidos son obligatoria");
			}

			empleadoEntity.setEstado("ACTIVO");
			empleadoEntity.setFechaRegistro(new Timestamp(System.currentTimeMillis()));

			empleadoRepository.save(empleadoEntity);
			Empleado empleadoReturn = new Empleado();
			empleadoReturn.setId(empleadoEntity.getId());

			return empleadoReturn;
		} catch (EmpleadoException ex) {
			throw new EmpleadoException("Se presento un error en la solicitud", ex);
		}
	}

	public List<Empleado> getAllEmpleados(LocalDateTime fechaInicio,LocalDateTime fechaFin) throws EmpleadoException {
		
		List<EmpleadoEntity> empleados = new ArrayList<>(); 
		List<Empleado> empleadosResponse = new ArrayList<>();
		
		if(fechaInicio == null && fechaFin == null) {
			empleados = empleadoRepository.findAll();
		}
		else {
			empleados = empleadoRepository.findByFechaRegistroBetween(Timestamp.valueOf(fechaInicio), Timestamp.valueOf(fechaFin));
		}

		for (EmpleadoEntity empleado : empleados) {
			Empleado empleadoResponse = new Empleado();
			empleadoResponse.setId(empleado.getId());
			empleadoResponse.setNombres(empleado.getNombres());
			empleadoResponse.setApellidos(empleado.getApellidos());
			empleadoResponse.setIdentificacion(empleado.getIdentificacion());
			empleadoResponse.setTipoIdentificacion(empleado.getTipoIdentificacion());
			empleadoResponse.setEstado(empleado.getEstado());
			LocalDateTime offsetDateTime = empleado.getFechaRegistro().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDateTime();
			empleadoResponse.setFechaRegistro(offsetDateTime);
			empleadosResponse.add(empleadoResponse);
		}
		return empleadosResponse;
	}

	public Empleado getById(int id) throws EmpleadoException {

		try {
			EmpleadoEntity empleadoEntity = empleadoRepository.findById(id);
			Empleado empleadoResponse = new Empleado();
			empleadoResponse.setId(empleadoEntity.getId());
			empleadoResponse.setIdentificacion(empleadoEntity.getIdentificacion());
			empleadoResponse.setTipoIdentificacion(empleadoEntity.getTipoIdentificacion());
			empleadoResponse.setNombres(empleadoEntity.getNombres());
			empleadoResponse.setApellidos(empleadoEntity.getApellidos());
			empleadoResponse.setEstado(empleadoEntity.getEstado());
			LocalDateTime offsetDateTime = empleadoEntity.getFechaRegistro().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDateTime();
			empleadoResponse.setFechaRegistro(offsetDateTime);
			return empleadoResponse;
		} catch (EmpleadoException ex) {
			throw new EmpleadoException("Se presento un error en la solicitud", ex);
		}
	}

	public void updateEmpleado(Empleado empleado, int id) throws EmpleadoException {

		try {
			EmpleadoEntity empleadoEntity = new EmpleadoEntity();
			empleadoEntity = empleadoRepository.findById(id);

			if (empleado.getIdentificacion() != null) {
				empleadoEntity.setIdentificacion(empleado.getIdentificacion());
			}

			if (empleado.getNombres() != null) {
				empleadoEntity.setNombres(empleado.getNombres());
			}

			if (empleado.getApellidos() != null) {
				empleadoEntity.setApellidos(empleado.getApellidos());
			}

			if (empleado.getTipoIdentificacion() != null) {
				empleadoEntity.setTipoIdentificacion(empleado.getTipoIdentificacion());
			}

			empleadoRepository.save(empleadoEntity);
		} catch (EmpleadoException ex) {
			throw new EmpleadoException("Se presento un error en la solicitud", ex);
		}
	}

	public void deleteCliente(int idEmpleado) {
		try {
			EmpleadoEntity empleadoEntity = empleadoRepository.findById(idEmpleado);
			empleadoRepository.delete(empleadoEntity);
		} catch (EmpleadoException ex) {
			throw new EmpleadoException("Se presento un error en la solicitud", ex);
		}
	}

}
