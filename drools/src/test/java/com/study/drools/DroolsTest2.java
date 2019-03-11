package com.study.drools;

import com.study.drools.model.Address;
import com.study.drools.model.fact.AddressCheckResult;
import com.study.drools.util.RandomUtils;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;

public class DroolsTest2 extends DroolsApplicationTests {

    @Autowired
    private KieSession kieSession;

    @Test
    public void test(){

        Address address = new Address();
        String generateRandom = RandomUtils.generateRandom(5);
        address.setPostcode(generateRandom);
        AddressCheckResult result = new AddressCheckResult();

//        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(address);
        kieSession.insert(result);

        int ruleFiredCount = kieSession.fireAllRules();

        kieSession.destroy();

        System.out.println("触发了" + ruleFiredCount + "条规则");

        if (result.isPostCodeResult()) {
            System.out.println("规则校验通过");
        }
    }
}
