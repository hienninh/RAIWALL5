package com.vti.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

import com.vti.entity.ResetPasswordToken;

public interface IRegistrationResetPasswordRepository extends JpaAttributeConverter<ResetPasswordToken, Integer> {
	public boolean existByToken(String token);
}
