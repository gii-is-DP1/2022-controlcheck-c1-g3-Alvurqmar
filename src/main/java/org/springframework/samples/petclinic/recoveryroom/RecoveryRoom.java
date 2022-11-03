package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_rooms")
public class RecoveryRoom extends BaseEntity{
    
	@Size(min = 3, max = 50)
	@NotNull
    private String name;
    
	@PositiveOrZero
	@NotNull
	private double size;
	@NotNull
    private boolean secure;
    
	@Transient
    RecoveryRoomType roomType;
}
