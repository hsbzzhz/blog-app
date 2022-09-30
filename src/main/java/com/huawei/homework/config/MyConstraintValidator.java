package com.huawei.homework.config;

import com.huawei.homework.utils.GenderCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<GenderCheck,String> {
    @Override
    public void initialize(GenderCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        System.out.println("my validator 初始化！");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.equals("1") || s.equals("0")){
            return true;
        }
        return false;
    }
}
