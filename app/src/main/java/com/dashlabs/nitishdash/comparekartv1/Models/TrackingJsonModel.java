package com.dashlabs.nitishdash.comparekartv1.Models;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by Nitish Dash on 4/22/2017.
 */


public class TrackingJsonModel {

    private List<ProductDetail> productDetails = null;
    private List<TrackingDetail> trackingDetails = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public List<TrackingDetail> getTrackingDetails() {
        return trackingDetails;
    }

    public void setTrackingDetails(List<TrackingDetail> trackingDetails) {
        this.trackingDetails = trackingDetails;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

