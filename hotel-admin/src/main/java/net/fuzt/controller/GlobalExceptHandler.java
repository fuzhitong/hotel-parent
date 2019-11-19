/**
 * Project Name:hotel-admin
 * File Name:GlobalExceptHandler.java
 * Package Name:com.java.controller
 * Date:下午3:08:41
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package net.fuzt.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Description: Date: 下午3:08:41 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
@ControllerAdvice
public class GlobalExceptHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptHandler.class);

    @ExceptionHandler(Exception.class)
    public String toErrorPages(Exception ex) {
        // 记录日志
        //System.out.println("GlobalExceptHandler.............toErrorPages");
        // logger.error(ex.getMessage());
        ex.printStackTrace();
        return "redirect:/pages/error/error.jsp";
    }

}
