package com.study.drools.listenter;

import com.study.drools.model.Rule;
import com.study.drools.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import java.util.List;

public class DroolsInitDrlFileListenter implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private RuleRepository ruleRepository;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {

        // 初始化加载规则文件到内存
        List<Rule> ruleList = ruleRepository.findAll();
        ruleList.forEach(rule -> {
            System.out.println(rule.getContent());
        });
    }
}
