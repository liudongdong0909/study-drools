package com.study.drools.repository;

import com.study.drools.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long> {
    Rule findByRuleKey(String ruleKey);
}