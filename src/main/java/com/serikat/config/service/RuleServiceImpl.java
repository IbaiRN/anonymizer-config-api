package com.serikat.config.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serikat.config.converters.RuleConverter;
import com.serikat.config.entity.RuleEntity;
import com.serikat.config.model.Rule;
import com.serikat.config.repository.RuleRepository;



@Service
public class RuleServiceImpl implements RuleService{

	@Autowired  
	private RuleRepository refactorRepository;
	
	@Autowired  
	private RuleConverter rulesConverter;
	

	//Guardado en BBDD de Rules
	@Override
	 public Rule saveRefactor(Rule refactor) {
		RuleEntity entity= new RuleEntity();
		entity=rulesConverter.convert(refactor);
		entity = refactorRepository.save(entity);
		return rulesConverter.convertEntyModel2(entity);
	    }
	
	
	//Listado de Rules
	@Override
	 public List<Rule> listAllRules() {
	    List<RuleEntity> entity = new ArrayList<>();
	
		entity.addAll((Collection<? extends RuleEntity>) refactorRepository.findAll());
		List<Rule> refactor= new ArrayList<>();
		refactor=rulesConverter.convertEntyModel(entity);
        return refactor;
	    }

	//Borra las filas de Rules en la base de datos
	@Override
	public void deleteRefactor(List<Rule> refactor) {
		List<RuleEntity> entity= new ArrayList<>();
		for(Rule ref: refactor) {
			entity.add(rulesConverter.convert(ref));
		}
		
		
		refactorRepository.deleteAll(entity);
		
	}

	
	//Actualiza Tabla Rules con las filas modificadas
	@Override
	public  Rule updateRefactor(Rule refactor1) {
		RuleEntity entity= new RuleEntity();
		entity=rulesConverter.convert(refactor1);
		//entity.setId(null);
		entity= refactorRepository.save(entity);
		return rulesConverter.convertEntyModel2(entity);
	}
}
