package com.library.utility;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BusinessExceptionHandler {
    /**
     * 拦截捕捉自定义异常 BusinessException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map myErrorHandler(Exception ex) {
        Map map = new HashMap();
        if(ex instanceof BusinessException){
            map.put("code", ((BusinessException)ex).getCode());
            map.put("message", ex.getMessage());
            map.put("data",null);
        }
        else if(ex instanceof Exception){
            map.put("code", 500);
            map.put("message", ex.getMessage());
            map.put("data",null);
        }
        return map;
    }
}
