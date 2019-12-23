package com.serikat.config.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serikat.config.model.Rule;
import com.serikat.config.model.UserPath;
import com.serikat.config.service.RuleService;
import com.serikat.config.service.UserPathService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ref")
public class ConfigController {

	@Autowired
	private RuleService refactorService;
	@Autowired
	private UserPathService moveService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/rename")
	public ResponseEntity rename(@RequestBody Rule[] refactor) {

		// Guardado de filas nuevas y se actualizan las existentes
		for (int i = 0; i < refactor.length; i++) {
			if (refactor[i].getActivecheck().equals("true")) {
				refactor[i].setActivecheck("A");
			} else {
				refactor[i].setActivecheck("D");
			}
			if (refactor[i].getId() == null) {
				refactor[i] = refactorService.saveRefactor(refactor[i]);
			} else {
				refactor[i] = refactorService.updateRefactor(refactor[i]);
			}
		}

		// Capturar las filas que han borrado
		List<Rule> refacdelete = new ArrayList<>();
		refacdelete = refactorService.listAllRules();
		for (int i = 0; i < refacdelete.size(); i++) {
			for (Rule refactor1 : refactor) {
				if (refacdelete.get(i).equals(refactor1)) {
					refacdelete.remove(i);
				}
			}
		}

		refactorService.deleteRefactor(refacdelete);
		Map<Object, Object> model = new HashMap<>();
		model.put("message", "Words registered successfully");
		return ok(model);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/move")
	public ResponseEntity move(@RequestBody UserPath[] move) {
		// Guardado de filas nuevas y se actualizan las existentes
		for (int i = 0; i < move.length; i++) {
			// Activar o desactivar los userPaths
			if (move[i].getActivecheck().equals("true")) {
				move[i].setActivecheck("A");
			} else {
				move[i].setActivecheck("D");
			}
			// Guardar o actualizar las userPaths
			if (move[i].getId() == null) {
				move[i] = moveService.saveMove(move[i]);
			} else {
				move[i] = moveService.updatemove(move[i]);
			}
		}

		// Capturar las filas que han borrado
		List<UserPath> movdelete = new ArrayList<>();
		movdelete = moveService.listAllMove();
		for (int i = 0; i < movdelete.size(); i++) {
			for (UserPath move2 : move) {
				if (movdelete.get(i).equals(move2)) {
					movdelete.remove(i);
				}
			}
		}

		// Conflicto entre List<Move> y Move[] en deleteMove()
		moveService.deleteMove(movdelete);

		Map<Object, Object> model = new HashMap<>();
		model.put("message", "Paths registered successfully");
		return ok(model);
	}

	@GetMapping("/getRules")
	public List<Rule> getRules() {

		// Lista de las rules de la BBDD para devolver a angular
		List<Rule> refac = new ArrayList<>();
		refac = refactorService.listAllRules();

		return refac;
	}

	@GetMapping("/getMoves")
	public List<UserPath> getMoves() {

		List<UserPath> refac = new ArrayList<>();
		refac = moveService.listAllMove();

		return refac;

	}

}
