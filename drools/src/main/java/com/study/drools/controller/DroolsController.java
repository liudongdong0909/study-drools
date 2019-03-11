package com.study.drools.controller;

import com.study.drools.model.Address;
import com.study.drools.model.fact.AddressCheckResult;
import com.study.drools.service.DroolsRuleService;
import com.study.drools.util.RandomUtils;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Arrays;

@RequestMapping("/drools")
@Controller
public class DroolsController {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private DroolsRuleService droolsRuleService;

    @ResponseBody
    @GetMapping("/address")
    public void test(@RequestParam Integer num) {

        Address address = new Address();
        String random = RandomUtils.generateRandom(num);
        address.setPostcode(random);

        AddressCheckResult result = new AddressCheckResult();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");

        kieSession.destroy();

        if (result.isPostCodeResult()) {
            System.out.println("规则校验通过");
        }
    }

    @GetMapping("/reload")
    @ResponseBody
    public String reload() throws IOException {
        droolsRuleService.reload();


        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        //\address.drl
        Resource[] resources = resourcePatternResolver.getResources("classpath*:" + "rule/" + "**/*.*");
        Arrays.stream(resources).forEach(resource ->{

            try {
                System.out.println(resource.getFilename());
                System.out.println(resource.getURL());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return"OK";
}
}