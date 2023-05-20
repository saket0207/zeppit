package com.ecommerce.zeppitProduct.controller;

import com.ecommerce.zeppitProduct.entity.Brand;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.service.BrandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ecommerce.zeppitProduct.utility.Constants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = API, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class BrandController {

    private static final Logger LOG = LogManager.getLogger(BrandController.class);
    @Autowired
    BrandService brandService;

    @GetMapping(ALL_BRAND)
    public ResponseEntity<ApiResponse<List<Brand>>> getAllBrandds(){
        LOG.info("Execution of fetch all brands execution starts ");
        ApiResponse<List<Brand>> brands = brandService.getAllBrands();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @GetMapping(BRAND_WITH_ID)
    public ResponseEntity<ApiResponse<Brand>> getBrandById(@PathVariable(BRAND_ID) Integer brandId){

        ApiResponse<Brand> brandById = brandService.getBrandById(brandId);
        return new ResponseEntity<>(brandById, HttpStatus.OK);
    }

    @PostMapping(BRAND)
    public ResponseEntity<ApiResponse<Brand>> createBrand(@RequestBody Brand brand){
        ApiResponse<Brand> brandSuccessResponse = brandService.createBrand(brand);
        return new ResponseEntity<>(brandSuccessResponse, HttpStatus.CREATED);
    }

    @PutMapping(BRAND_WITH_ID)
    public ResponseEntity<ApiResponse<Brand>> updateBrandBy(@PathVariable(BRAND_ID) Integer brandId, @RequestBody Brand brand){

        ApiResponse<Brand> brandSuccessResponse = brandService.updateBrand(brandId, brand);
        return new ResponseEntity<>(brandSuccessResponse, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(BRAND_WITH_ID)
    public ResponseEntity<Object> deleteBrandById(@PathVariable(BRAND_ID) Integer brandId){

        ApiResponse<Object> brandSuccessResponse = brandService.deleteBrandById(brandId);
        return new ResponseEntity<>(brandSuccessResponse, HttpStatus.OK);
    }


}
