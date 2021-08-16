package posutfpr.banco.ativcinco.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import posutfpr.banco.ativcinco.entity.DepartamentEntity;
import posutfpr.banco.ativcinco.entity.FuncEntity;
import posutfpr.banco.ativcinco.repository.FuncRepository;


//UTFPR — Universidade Tecnológica Federal do Paraná UTFPR
//XXI Curso de Especialização em Tecnologia Java (2021_01)
//Banco de Dados
//Atividade 7
//Cleber dos Santos Prestes de Oliveira



@Service
public class FuncService {

	@Autowired
	private FuncRepository funcRepository;

	public FuncEntity saveFunc(FuncEntity funcEntity) {
		return funcRepository.save(funcEntity);
	}
	
	
	// Atividade 7.1
	public void salaryReadjustment(Integer reajuste) {
		
		funcRepository.procedureReajuste(reajuste);
	}
	
	
	// Atividade 7.2
	public List<FuncEntity> findByNamedParam(Integer dependents, String depart) {
		return funcRepository.findByNamedParam(dependents, depart);
	}

	
	// Atividade 7.3
	public int updateFuncDepart(DepartamentEntity niw, DepartamentEntity old) {
	//public int updateFuncDepart(String niw, String old) {
			
			return funcRepository.updateDepartById(niw, old);
			
	}
		
	// Atividade 7.4
	public int deleteFuncByDepart(Long idDepart) {
					
			return funcRepository.deleteDepartById(idDepart);
	}

}
