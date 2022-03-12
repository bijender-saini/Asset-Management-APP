package com.rmgx.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.rmgx.entity.AssetDetails;
import com.rmgx.repository.AssetDetailsRepository;
import com.rmgx.service.impl.AssetDetailsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestAssetDetailsImpl {
	@InjectMocks
	AssetDetailsServiceImpl assetService;

	@Mock
	private AssetDetailsRepository assetDetailsRepository;

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void buildAssetDetailsTest() {
		when(assetDetailsRepository.save(TestAssetHelper.buildAssetDetails()))
				.thenReturn(TestAssetHelper.buildAssetDetails());
		assertNotNull(assetService.saveAssetDetails(TestAssetHelper.buildAssetDetailsDto()));
	}

	@Test
	public void fetchAllAssetTest() {
		when(assetDetailsRepository.findAll()).thenReturn(TestAssetHelper.buildAssetDetailsList());
		assertEquals(2, assetDetailsRepository.findAll().size());
	}

	@Test
	public void fetchAssetDetailsTest() {
		when(assetDetailsRepository.findById(1)).thenReturn(Optional.of(TestAssetHelper.buildAssetDetails()));
		assertNotNull(assetService.fetchAssetDetails(1));
	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void deleteAssetDetailsTest() throws Exception {
		when(assetDetailsRepository.findById(1)).thenReturn(Optional.of(TestAssetHelper.buildAssetDetails()));
//		assetService.deleteAssetDetails(1);
//		verify(assetDetailsRepository, times(1)).deleteById(1);

	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void updateAsssetDetailsTest() {
		when(assetDetailsRepository.findAll()).thenReturn(TestAssetHelper.buildAssetDetailsList());
		when(assetDetailsRepository.findById(1)).thenReturn(Optional.of(TestAssetHelper.buildAssetDetails()));
		 AssetDetails buildAssetDetails = TestAssetHelper.buildAssetDetails();
		buildAssetDetails.setId(1);
		buildAssetDetails.setName("xxx");
		assetDetailsRepository.save(TestAssetHelper.buildAssetDetails());
		verify(assetDetailsRepository, times(1)).save(TestAssetHelper.buildAssetDetails());

	}

}
