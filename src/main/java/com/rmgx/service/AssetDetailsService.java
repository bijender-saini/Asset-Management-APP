package com.rmgx.service;

import java.util.List;

import com.rmgx.dto.AssetDetailsDto;
import com.rmgx.entity.AssetDetails;

public interface AssetDetailsService {

	public AssetDetails saveAssetDetails(AssetDetailsDto assetDetailsDto);

	public AssetDetails fetchAssetDetails(Integer id);

	public List<AssetDetails> fetchAllAssetDetails();

	public String deleteAssetDetails(Integer id);

	public String updateAssetDetails(Integer id, AssetDetailsDto assetDetailsDto);

	List<AssetDetails> searchAssetByName(String name);

}
