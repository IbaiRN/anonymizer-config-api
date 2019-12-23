package com.serikat.config.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.serikat.config.entity.UserPathEntity;
import com.serikat.config.model.UserPath;

// Transforma los modelos en entidades para la bbdd y viceversa.

@Component
public class UserPathConverter implements Converter<UserPath, UserPathEntity> {

	// model --> entity
	@Override
	public UserPathEntity convert(UserPath move) {
		
		UserPathEntity moveEntity = new UserPathEntity();
		
		moveEntity.setOriginPath(move.getOriginpath());
		moveEntity.setTargetPath(move.getTargetpath());
		moveEntity.setId(move.getId());
		moveEntity.setStatus(move.getActivecheck());

		return moveEntity;
	}

	// entity --> model
	public List<UserPath> convertEntyModel(List<UserPathEntity> entityM) {
		
		List<UserPath> move = new ArrayList<>();
		
		for (UserPathEntity entyM : entityM) {
			
			UserPath mov = new UserPath();
			
			mov.setId(entyM.getId());
			mov.setOriginpath(entyM.getOriginPath());
			mov.setTargetpath(entyM.getTargetPath());
			mov.setActivecheck(entyM.getStatus());

			move.add(mov);
		}

		return move;
	}

	// List entity --> List model
	public UserPath convertEntyModel2(UserPathEntity entityM) {

		UserPath mov = new UserPath();

		mov.setId(entityM.getId());
		mov.setOriginpath(entityM.getOriginPath());
		mov.setTargetpath(entityM.getTargetPath());
		mov.setActivecheck(entityM.getStatus());

		return mov;

	}

}
