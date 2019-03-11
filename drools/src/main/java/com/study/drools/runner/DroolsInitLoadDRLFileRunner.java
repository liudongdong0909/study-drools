package com.study.drools.runner;

import com.study.drools.model.Rule;
import com.study.drools.repository.RuleRepository;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author walle
 * @version 1.0
 * @create 2019-03-11
 */
@Component
public class DroolsInitLoadDRLFileRunner implements CommandLineRunner {

    public static final Logger LOGGER = LoggerFactory.getLogger(DroolsInitLoadDRLFileRunner.class);

    @Autowired
    private RuleRepository ruleRepository;

    @Override
    public void run(String... args) throws Exception {

        // 初始化加载规则文件到内存
        LOGGER.info(">>>>>  开始初始化读取所有规则文件到内存中 <<<<<");
        List<Rule> ruleList = ruleRepository.findAll();
        ruleList.forEach(rule -> {
            LOGGER.info("读取规则:[{}], 状态:[{}], 内容:[{}]", rule.getRuleKey(), rule.getEnableStatus(), rule.getContent());
        });
        LOGGER.info(">>>>> 总计加载[{}]个规则文件 <<<<<", ruleList.size());

        this.loadContainerToString(ruleList);
        LOGGER.info(">>>>> 初始化读取所有规则文件到内存中完成 <<<<<");
    }

    private KieContainer loadContainerToString(List<Rule> rules){

        KieServices kieServices = KieServices.Factory.get();
        KieRepository kieRepository = kieServices.getRepository();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        rules.forEach(rule -> {
            String drlContent = rule.getContent();
            kieFileSystem.write("src/main/resources/rules/" + drlContent.hashCode() + ".drl", drlContent);
        });

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)){
            LOGGER.error("规则文件编译错误：{}", kieBuilder.getResults().toString());
        }

        KieContainer kieContainer = kieServices.newKieContainer(kieRepository.getDefaultReleaseId());

        return kieContainer;
    }
}
