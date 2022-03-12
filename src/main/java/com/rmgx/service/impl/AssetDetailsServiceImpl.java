package com.rmgx.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmgx.dto.AssetDetailsDto;
import com.rmgx.dto.EmployeeDetailsDto;
import com.rmgx.entity.AssetDetails;
import com.rmgx.entity.Category;
import com.rmgx.entity.EmployeeDetails;
import com.rmgx.enums.AssetAssignmentStatus;
import com.rmgx.exception.AssetNotDeletedExcetion;
import com.rmgx.exception.DataNotFoundException;
import com.rmgx.repository.AssetDetailsRepository;
import com.rmgx.service.AssetDetailsService;

@Service
public class AssetDetailsServiceImpl implements AssetDetailsService {
	@Autowired
	private AssetDetailsRepository assetDetailsRepository;

	@Override
	public AssetDetails saveAssetDetails(AssetDetailsDto assetDetailsDto) {

		AssetDetails assetDetails = new AssetDetails();
		assetDetails.setName(assetDetailsDto.getName());
		assetDetails.setPurchasedDate(assetDetailsDto.getPurchasedDate());
		assetDetails.setAssetCondition(assetDetailsDto.getAssetCondition());
		assetDetails.setAssignmentStatus(assetDetailsDto.getAssignmentStatus());

		// foreign key integration
		Category category = assetDetails.getCategory();
		category.setId(assetDetailsDto.getCategoryId());

		switch (assetDetailsDto.getAssignmentStatus()) {

		case AssetAssignmentStatus.AVAILABLE:

			assetDetails.setEmployeeDetails(null);
			break;

		default:
			EmployeeDetails employeeDetails = assetDetails.getEmployeeDetails();
			employeeDetails.setId(assetDetailsDto.getEmployeeId());
			break;

		}

		return assetDetailsRepository.save(assetDetails);
	}

	@Override
	public AssetDetails fetchAssetDetails(Integer id) {

		Optional<AssetDetails> findById = assetDetailsRepository.findById(id);
		if (!findById.isPresent()) {
			throw new DataNotFoundException("Asset not found");
		}
		return findById.get();
	}

	@Override
	public List<AssetDetails> fetchAllAssetDetails() {
		List<AssetDetails> assetList = assetDetailsRepository.findAll();
		if (assetList.isEmpty()) {
			throw new DataNotFoundException("Asset not found");
		}
		return assetList;
	}

	@Override
	public String deleteAssetDetails(Integer id) {
		Optional<AssetDetails> findById = assetDetailsRepository.findById(id);
		if (!findById.isPresent()) {
			throw new DataNotFoundException("Asset not found");
		}
		if (findById.get().getAssignmentStatus().equals(AssetAssignmentStatus.ASSIGNED)) {
			throw new AssetNotDeletedExcetion("asset not deleted because it is assigned to someone");
		}
		assetDetailsRepository.deleteById(id);
		return "asset deleted successfully.";
	}

	@Override
	public String updateAssetDetails(Integer id, AssetDetailsDto assetDetailsDto) {
		AssetDetails assetDetails = fetchAssetDetails(id);
		assetDetails.setName(assetDetailsDto.getName());
		assetDetails.setPurchasedDate(assetDetailsDto.getPurchasedDate());
		assetDetails.setAssetCondition(assetDetailsDto.getAssetCondition());
		assetDetails.setAssignmentStatus(assetDetailsDto.getAssignmentStatus());
		Category category = assetDetails.getCategory();
		category.setId(assetDetailsDto.getCategoryId());
		assetDetailsRepository.save(assetDetails);
		return "asset updated successfully.";
	}

	@Override
	public List<AssetDetails> searchAssetByName(String name) {
		List<AssetDetails> assetList = assetDetailsRepository.findByName(name);
		if (assetList.isEmpty()) {
			throw new DataNotFoundException("Asset not found");
		}
		return assetList;
	}

}
