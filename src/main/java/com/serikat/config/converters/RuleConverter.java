package com.serikat.config.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.serikat.config.entity.RuleEntity;
import com.serikat.config.model.Rule;


@Component
public class RuleConverter implements Converter<Rule, RuleEntity>{
	
	//model --> entity
	@Override
    public RuleEntity convert(Rule refactor) {
		RuleEntity rulesEntity = new RuleEntity();
		rulesEntity.setSearchType(refactor.getWord_to_rename());
		rulesEntity.setChangeType(refactor.getRenowned_word());
		rulesEntity.setName(refactor.getName());
		rulesEntity.setId(refactor.getId());
		rulesEntity.setStatus(refactor.getActivecheck());
        return rulesEntity;
    }
	
	//entity --> model
	public Rule convertEntyModel2(RuleEntity entity) {
	        Rule refac = new Rule();
			refac.setId(entity.getId());
			refac.setWord_to_rename(entity.getSearchType());
			refac.setRenowned_word(entity.getChangeType());
			refac.setName(entity.getName());
			refac.setActivecheck(entity.getStatus());
			return refac;
	}

	//List entity --> List model
	public List<Rule> convertEntyModel(List<RuleEntity> entity) {
		List<Rule> refactor = new ArrayList<>();
		for(RuleEntity enty : entity) {
			Rule refac = new Rule();
			refac.setId(enty.getId());
			refac.setWord_to_rename(enty.getSearchType());
			refac.setRenowned_word(enty.getChangeType());
			refac.setName(enty.getName());
			refac.setActivecheck(enty.getStatus());
			refactor.add(refac);
		}
		
        return refactor;
	}
}
