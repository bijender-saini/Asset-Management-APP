package com.rmgx.helper;

import java.util.ArrayList;
import java.util.List;

import com.rmgx.dto.AssetDetailsDto;
import com.rmgx.entity.AssetDetails;

public class TestAssetHelper {

	static AssetDetailsDto buildAssetDetailsDto() {

		AssetDetailsDto ad = new AssetDetailsDto();
		ad.setAssetCondition("good");
		ad.setName("xxx");
		ad.setAssignmentStatus("available");
		ad.setEmployeeId(1);
		ad.setCategoryId(1);
		return ad;
	}

	static List<AssetDetails> buildAssetDetailsList() {

		AssetDetails ad = new AssetDetails();
		ad.setAssetCondition("good");
		ad.setName("xxx");

		AssetDetails ad2 = new AssetDetails();
		ad2.setAssetCondition("worst");
		ad2.setName("yyy");

		ArrayList<AssetDetails> al = new ArrayList<AssetDetails>();
		al.add(ad);
		al.add(ad2);
		return al;
	}

	static AssetDetails buildAssetDetails() {
		AssetDetails ad = new AssetDetails();
		ad.setAssetCondition("good");
		ad.setAssignmentStatus("available");
		ad.setName("xxx");
		return ad;

	}

}
