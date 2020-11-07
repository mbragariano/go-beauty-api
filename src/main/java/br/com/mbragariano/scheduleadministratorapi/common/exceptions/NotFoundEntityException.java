package br.com.mbragariano.scheduleadministratorapi.common.exceptions;

public class NotFoundEntityException extends BaseException {

	public NotFoundEntityException(final String message, final String details, final String developerMessage) {
		super(message, details, developerMessage);
	}

}
