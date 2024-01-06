package com.roshan.uber.utils.geocode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Results {
    private String formatted_address;
    private Geometry geometry;
}
