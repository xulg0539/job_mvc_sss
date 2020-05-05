package com.lagou.edu.mvcframework.annotations;

import java.lang.annotation.*;

/**
 * @author xulin
 * @date 2020/5/2 12:01
 * @description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Security {
    String[] value();
}
