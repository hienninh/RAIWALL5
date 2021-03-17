package com.vti.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER,
		ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {groupNameNotValidation.class})
public @interface groupNameNotExist {
	String message() default "{createGroupDTO.groupName.groupNameNotExist}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
