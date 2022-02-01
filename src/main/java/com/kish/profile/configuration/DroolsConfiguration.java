package com.kish.profile.configuration;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfiguration {

    //private static final String DEFAULTING_RULE_DRL = "rules/defaulting-rule.drl";
    private static final String DEFAULTING_RULE_DRL = "rules/DefaultingRule.xls";

    private final KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieContainer getKieContainer() {
        KieFileSystem kieFileSystem = kieServices
                .newKieFileSystem()
                .write(ResourceFactory.newClassPathResource(DEFAULTING_RULE_DRL));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }
}
