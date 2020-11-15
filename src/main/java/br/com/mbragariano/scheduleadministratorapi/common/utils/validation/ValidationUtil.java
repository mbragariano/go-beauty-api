package br.com.mbragariano.scheduleadministratorapi.common.utils.validation;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.Util;
import br.com.mbragariano.scheduleadministratorapi.common.exceptions.EntityValidationException;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolverPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.validation.Validator;

@Util
@RequiredArgsConstructor
public class ValidationUtil {

	private final Validator validator;

	@Qualifier("messageSourceResolverAdapter")
	private final MessageResolverPort messageResolverPort;

	public void validate(final Object object, final ValidationUtilMessages validationUtilMessages, final Class... groups) {
		final var validationResult = this.validator.validate(object, groups);

		if (!validationResult.isEmpty())
			throw new EntityValidationException(
				this.messageResolverPort.resolveMessage(validationUtilMessages.message, new Object[]{}, LocaleContextHolder.getLocale()),
				this.messageResolverPort.resolveMessage(validationUtilMessages.details, new Object[]{}, LocaleContextHolder.getLocale()),
				null,
				ValidationUtilMapper.mapToEntityValidations(validationResult)
			);
	}

}
