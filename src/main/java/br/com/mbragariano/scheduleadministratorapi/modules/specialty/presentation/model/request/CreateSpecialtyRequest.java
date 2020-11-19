package br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSpecialtyRequest {

	public String name;

}
