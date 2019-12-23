package com.serikat.config.service;

import java.util.List;

import com.serikat.config.entity.UserPathEntity;
import com.serikat.config.model.UserPath;

public interface UserPathService {

	UserPath saveMove(UserPath move);

	List<UserPath> listAllMove();

	// List<Move> antes era Move[]
	void deleteMove(List<UserPath> move);

	UserPath updatemove(UserPath move);

}
