package io.github.zhoutaoq.mybatis.xmlreload.autoconfiguration;

import io.github.zhoutaoq.mybatis.xmlreload.MybatisXmlReload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.LazyInitializationExcludeFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * mybatis xml热加载自动配置
 *
 * @author wayn
 */
@Configuration
@EnableConfigurationProperties({MybatisXmlReloadProperties.class})
public class MybatisXmlReloadConfiguration {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    @ConditionalOnMissingBean
    public MybatisXmlReload mybatisXmlReload(MybatisXmlReloadProperties prop) throws IOException {
        MybatisXmlReload mybatisXmlReload = new MybatisXmlReload(prop, applicationContext);
        if (prop.getEnabled()) {
            mybatisXmlReload.xmlReload();
        }
        return mybatisXmlReload;
    }

    @Bean
    public static LazyInitializationExcludeFilter integrationLazyInitializationExcludeFilter() {
        return LazyInitializationExcludeFilter.forBeanTypes(MybatisXmlReload.class);
    }
}
