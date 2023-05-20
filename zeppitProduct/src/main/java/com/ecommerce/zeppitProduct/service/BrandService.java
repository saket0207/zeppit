package com.ecommerce.zeppitProduct.service;

import com.ecommerce.zeppitProduct.entity.Brand;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.model.ErrorApiResponse;
import com.ecommerce.zeppitProduct.model.SuccessApiResponse;
import com.ecommerce.zeppitProduct.repository.BrandRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class BrandService {
    private static final Logger LOG = LogManager.getLogger(BrandService.class);

    @Autowired
    BrandRepository brandRepository;
    public SuccessApiResponse<List<Brand>> getAllBrands() {

        Iterable<Brand> brandsIterable = brandRepository.findAll();

        List<Brand> brands = StreamSupport.stream(brandsIterable.spliterator(), false).toList();
        return new SuccessApiResponse<List<Brand>>("SuccessFully fetched all records", brands);

    }

    public SuccessApiResponse<Brand> getBrandById(Integer brandId){

        Optional<Brand> brand = brandRepository.findById(brandId);
        SuccessApiResponse<Brand> brandSuccessResponse = new SuccessApiResponse<>("Brand with id" + brandId+ "fetched successfully", brand.get());
        return brandSuccessResponse;
    }

    public SuccessApiResponse<Brand> createBrand(Brand brand){
        Brand createdBrand = brandRepository.save(brand);
        SuccessApiResponse<Brand> brandSuccessResponse = new SuccessApiResponse<>("Brand added successfully", createdBrand);
        return brandSuccessResponse;

    }

    public SuccessApiResponse<Brand> updateBrand(Integer brandId, Brand brand){
        Optional<Brand> brandById = brandRepository.findById(brandId);
        if(brandById.isEmpty()){
            return new SuccessApiResponse<>("No record found for given Id", null);
        }
        brand.setBrandId(brandId);
        Brand updatedBrand = brandRepository.save(brand);
        return new SuccessApiResponse<>("Brand updated Successfully", updatedBrand);

    }

    public ApiResponse<Object> deleteBrandById(Integer brandId){
        try {
            brandRepository.deleteById(brandId);
        } catch (Exception ex){
            LOG.error("Error in deletion of the brand ", ex);
            return new ErrorApiResponse<Object>("Brand deletion Failed", null);
        }

        return new SuccessApiResponse<Object>("Brand deletion successful", null);
    }
}
