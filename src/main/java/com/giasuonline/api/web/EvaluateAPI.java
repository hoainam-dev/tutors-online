package com.giasuonline.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giasuonline.dto.EvaluateDTO;
import com.giasuonline.service.IEvaluateService;

@RestController(value = "evaluateAPIOfWeb")
public class EvaluateAPI {
	@Autowired
	private IEvaluateService evaluateService;
	
	@GetMapping("/api/evaluate")
	public List<EvaluateDTO> getEvaluate() {
		List<EvaluateDTO> evaluates = evaluateService.findAll();
		return evaluates;

	}
	
	@PostMapping("/api/evaluate")
	public EvaluateDTO createEvaluate(@RequestBody EvaluateDTO evaluateDTO) {
		return evaluateService.save(evaluateDTO);
	}
	
	@PutMapping("/api/evaluate")
	public EvaluateDTO updateEvaluate(@RequestBody EvaluateDTO evaluateDTO) {
		return evaluateService.save(evaluateDTO);
	}
	
	@DeleteMapping("/api/evaluate")
	public void deleteEvaluate(@RequestBody long[] ids) {
		evaluateService.delete(ids);
		System.out.println("delete successfully!");
	}
}
