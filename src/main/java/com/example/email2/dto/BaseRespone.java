package com.example.email2.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseRespone<T> {
    Boolean success = false;
    String errMsg = "";
    T Data = null;
}
