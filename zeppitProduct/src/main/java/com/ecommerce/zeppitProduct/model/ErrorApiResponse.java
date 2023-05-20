package com.ecommerce.zeppitProduct.model;

public class ErrorApiResponse<T> extends ApiResponse<T> {

    private T t;
    public ErrorApiResponse(String message, T t){
        super(message);
        this.t = t;
    }
}
