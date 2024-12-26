package io.github.zhoutaoq.mybatis.xmlreload.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * mybatis-xml-reload配置属性类
 */
@ConfigurationProperties(prefix = "mybatis-xml-reload")
public class MybatisXmlReloadProperties {
    private boolean enabled = true;

    private String[] mapperLocations = {"classpath*:mybatis/**/*.xml", "classpath*:mybatis/*.xml"};

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String[] getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String[] mapperLocations) {
        this.mapperLocations = mapperLocations;
    }
}
