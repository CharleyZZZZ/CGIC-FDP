package org.cgic.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/10/12 9:48
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "cgic.oauth.helper")
public class CgicGatewayProperties {


    private String userInfoUri = "http://localhost:8082/api/hr/info";

    /**
     * helper 服务id
     */
    private String serviceId = "cgic-oauth";

    /**
     * 放行 路径集合
     */
    private String[] releasedPath = new String[0];

    private String jwtKey = "cgicjwt";

    /**
     * 是否启用
     */
    private boolean enabled = true;

    public CgicGatewayProperties() {
    }

    public String getJwtKey() {
        return jwtKey;
    }

    public void setJwtKey(String jwtKey) {
        this.jwtKey = jwtKey;
    }

    public String getUserInfoUri() {
        return userInfoUri;
    }

    public void setUserInfoUri(String userInfoUri) {
        this.userInfoUri = userInfoUri;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String[] getReleasedPath() {
        return releasedPath;
    }

    public void setReleasedPath(String[] releasedPath) {
        this.releasedPath = releasedPath;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "CgicGatewayProperties{" +
                "serviceId='" + serviceId + '\'' +
                ", releasedPath=" + Arrays.toString(releasedPath) +
                ", enabled=" + enabled +
                '}';
    }
}
