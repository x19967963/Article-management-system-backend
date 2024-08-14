package com.junhan.big_event.anno;

import com.junhan.big_event.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {StateValidation.class}//指定提供校驗規則的類
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    //提供校驗失敗的訊息
    String message() default "{state參數的值只能是已發布或是草稿}";
    //指定分組
    Class<?>[] groups() default {};
    //附載，獲得state的附加訊息
    Class<? extends Payload>[] payload() default {};
}
