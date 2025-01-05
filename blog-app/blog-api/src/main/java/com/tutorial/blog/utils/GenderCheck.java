package com.tutorial.blog.utils;

import com.tutorial.blog.config.MyConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)  //还要个这个？
public @interface GenderCheck {
    String message() default "性别有奇异！";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
