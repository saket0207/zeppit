package com.ecommerce.zeppitProduct.utility;

public class Constants {

    public static final String API = "api";
    public static final String PRODUCT_WITH_ID = "/product/{productid}";
    public static final String ALL_PRODUCT = "/products";
    public static final String PRODUCT = "/product";
    public static final String PRODUCT_ID = "productid";

    public static final String CATEGORY_WITH_ID = "/category/{categoryid}";
    public static final String ALL_CATEGORY = "/categories";
    public static final String CATEGORY = "/category";
    public static final String CATEGORY_ID = "categoryid";

    public static final String ALL_BRAND = "/brands";
    public static final String BRAND_WITH_ID = "/brand/{brandid}";
    public static final String BRAND = "/brand";
    public static final String BRAND_ID = "brandid";

    public static final String PRODUCT_IMAGE_WITH_ID = "/productimage/{productimageid}";
    public static final String ALL_PRODUCT_IMAGE = "/productimages";
    public static final String PRODUCT_IMAGE = "/productimage";
    public static final String PRODUCT_IMAGE_ID = "productimageid";

    public static final String PRODUCT_REVIEW_WITH_ID = "/productreview/{productreviewid}";
    public static final String ALL_PRODUCT_REVIEW = "/productreviews";
    public static final String PRODUCT_REVIEW = "/productreview";
    public static final String PRODUCT_REVIEW_ID = "productreviewid";


    public static final String PRODUCT_IMAGE_WITH_PID = "/productimage/{productid}";

    public static final String PRODUCT_REVIEW_WITH_PID = "/productreview/{productid}";

    public static final String FIND_ALL_PI_BY_PRODUCT_ID = "SELECT * FROM PRODUCT_IMAGE pi WHERE pi.PRODUCT_ID = ?1";

    public static final String FIND_ALL_PR_BY_PRODUCT_ID = "SELECT * FROM ProductReview pr WHERE pr.PRODUCT_ID = ?1";
}
