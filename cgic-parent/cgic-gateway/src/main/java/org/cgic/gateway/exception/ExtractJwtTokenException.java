package org.cgic.gateway.exception;

import org.cgic.commons.exception.BaseException;

/**
 * @Description  导出生成 jwt_token 异常
 * @Author: charleyZZZZ
 * @Date: 2019/12/2 17:14
 * @Version 1.0
 */
public class ExtractJwtTokenException extends BaseException{


    protected ExtractJwtTokenException(String code, String descriptionKey, Object[] parameters) {
        super(code, descriptionKey, parameters);
    }

    public ExtractJwtTokenException(String code, String message) {
        this(code, message, (Object[])null);
    }
}
