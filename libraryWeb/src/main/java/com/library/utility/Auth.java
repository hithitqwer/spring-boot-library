package com.library.utility;

import io.swagger.annotations.Authorization;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Auth{
    String role() default "";
}
