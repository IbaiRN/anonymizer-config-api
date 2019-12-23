package com.serikat.config.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serikat.config.converters.UserPathConverter;
import com.serikat.config.entity.UserPathEntity;
import com.serikat.config.model.UserPath;
import com.serikat.config.repository.UserPathRepository;

@Service
public class UserPathServiceImpl implements UserPathService {

	@Autowired
	private UserPathRepository moveRepository;

	@Autowired
	private UserPathConverter moveConverter;

	// Guardado en BBDD de moves
	@Override
	public UserPath saveMove(UserPath move) {

		UserPathEntity entityM = new UserPathEntity();
		entityM = moveConverter.convert(move);
		moveRepository.save(entityM);

		return moveConverter.convertEntyModel2(entityM);

	}

	// Listado de moves
	@Override
	public List<UserPath> listAllMove() {

		List<UserPathEntity> entityM = new ArrayList<>();
		entityM.addAll((Collection<? extends UserPathEntity>) moveRepository.findAll());
		List<UserPath> move = new ArrayList<>();
		move = moveConverter.convertEntyModel(entityM);

		return move;

	}

	// Borra las filas de moves en la bbdd
	@Override
	public void deleteMove(List<UserPath> move) {

		List<UserPathEntity> entity = new ArrayList<>();
		for (UserPath ref : move) {
			entity.add(moveConverter.convert(ref));
		}
		moveRepository.deleteAll(entity);

	}

	// Actualiza la tabla de userpaths con las filas modificadas
	@Override
	public UserPath updatemove(UserPath move) {
		UserPathEntity entityM = new UserPathEntity();
		entityM = moveConverter.convert(move);
		entityM = moveRepository.save(entityM);

		return moveConverter.convertEntyModel2(entityM);

	}

}
