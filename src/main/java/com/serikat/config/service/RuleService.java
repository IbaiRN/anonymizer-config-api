package com.serikat.config.service;

import java.util.List;

import com.serikat.config.model.Rule;

public interface RuleService {
	Rule saveRefactor(Rule refactor);

	List<Rule> listAllRules();

	void deleteRefactor(List<Rule> refactor);

	Rule updateRefactor(Rule refactor1);
}
