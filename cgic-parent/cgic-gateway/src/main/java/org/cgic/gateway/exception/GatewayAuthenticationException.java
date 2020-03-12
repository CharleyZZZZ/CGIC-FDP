package org.cgic.gateway.exception;

import org.cgic.commons.exception.BaseException;

/**
 * @Description 网关鉴权异常
 * @Author: charleyZZZZ
 * @Date: 2019/12/2 17:20
 * @Version 1.0
 */
public class GatewayAuthenticationException extends BaseException {



    protected GatewayAuthenticationException(String code, String descriptionKey, Object[] parameters) {
        super(code, descriptionKey, parameters);
    }

    public GatewayAuthenticationException(String code, String message) {
        super(code, message, (Object[]) null);
    }
}
