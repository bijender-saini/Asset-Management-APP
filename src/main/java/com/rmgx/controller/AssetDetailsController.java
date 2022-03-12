package com.rmgx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rmgx.dto.AssetDetailsDto;
import com.rmgx.service.AssetDetailsService;
import com.rmgx.utils.ResponseHandler;

@RestController
public class AssetDetailsController {

	@Autowired
	private AssetDetailsService assetDetailsService;

	@PostMapping("saveAssetDetails")
	ResponseEntity<Object> saveAssetDetails(@RequestBody AssetDetailsDto assetDetailsDto) {
		return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "asset details saved successfully.",
				assetDetailsService.saveAssetDetails(assetDetailsDto));
	}

	@GetMapping("fetchAllAssetDetails")
	ResponseEntity<Object> fetchAllAssetDetails() {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success",
				assetDetailsService.fetchAllAssetDetails());
	}

	@GetMapping("fetchAssetDetails/{id}")
	ResponseEntity<Object> fetchAssetDetails(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success",
				assetDetailsService.fetchAssetDetails(id));

	}

	@DeleteMapping("deleteAssetDetails/{id}")
	ResponseEntity<Object> deleteAssetDetails(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, assetDetailsService.deleteAssetDetails(id));
	}

	@PutMapping("updateAssetDetails/{id}")
	ResponseEntity<Object> updateAssetDetails(@PathVariable("id") Integer id,
			@RequestBody AssetDetailsDto assetDetailsDto) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true,
				assetDetailsService.updateAssetDetails(id, assetDetailsDto));
	}

	@GetMapping("getAssetByName/{name}")
	ResponseEntity<Object> findAssetByName(@PathVariable("name") String name) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success",
				assetDetailsService.searchAssetByName(name));
	}
}
