package com.ecommerce.zeppitProduct.model;

public class SuccessApiResponse<T> extends ApiResponse<T> {

    private final T t;
    public SuccessApiResponse(String message, T t){
        super(message);
        this.t = t;
    }
}
