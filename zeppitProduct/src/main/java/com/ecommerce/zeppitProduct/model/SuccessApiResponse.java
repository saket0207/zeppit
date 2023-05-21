package com.ecommerce.zeppitProduct.model;

public class SuccessApiResponse<T> extends ApiResponse {

    private T t;
    public SuccessApiResponse(String message, T t){
        super(message);
        this.t = t;
    }
}
