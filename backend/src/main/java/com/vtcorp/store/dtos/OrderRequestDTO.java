package com.vtcorp.store.dtos;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private String cusName;
    private String cusMail;
    private String cusPhone;
    private String cusCity;
    private String cusDistrict;
    private String cusWard;
    private String cusStreet;

    private String voucherId;

    private List<CartItemDTO> orderDetails;

    private List<Long> giftIds;

}