package com.study.drools.listenter;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class DroolsInitDrlFileListenter implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
       String drl =  "package com.rules\n" +
                "\n" +
                "import com.study.drools.model.Address;\n" +
                "import com.study.drools.model.fact.AddressCheckResult;\n" +
                "\n" +
                "rule \"Postcode should be filled with exactly 5 numbers\"\n" +
                "\n" +
                "    when\n" +
                "        address : Address(postcode != null, postcode matches \"([0-9]{5})\")\n" +
                "        checkResult : AddressCheckResult();\n" +
                "    then\n" +
                "        checkResult.setPostCodeResult(true);\n" +
                "        System.out.println(\"规则中打印日志：校验通过!\");\n" +
                "end";
        System.out.println(drl);
    }
}
