package com.agenciadigital.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {
	public EmpleadoEntity findByIdentificacion(String identificacion);
	public EmpleadoEntity findById(int id);
	public void deleteById(int id);
	public List<EmpleadoEntity> findByFechaRegistroBetween(Timestamp fechaInicio,Timestamp fechaFin);
}
