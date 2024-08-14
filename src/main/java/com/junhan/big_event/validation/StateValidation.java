package com.junhan.big_event.validation;

import com.junhan.big_event.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {
    /***
     *
     * @param s 將來要校驗的數據
     * @param constraintValidatorContext
     * @return 如果返回false，校驗不通過，true則通過
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //提供校驗規則
        if (s == null) {
            return false;
        }
        if (s.equals("已發布")||s.equals("草稿")){
            return true;
        }
        return false;
    }
}
