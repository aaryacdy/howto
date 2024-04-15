package com.kathford.howto.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class PostDTO {

    private BigInteger id;

    private String  title;

    private String description;

    private String attachment;

    private String videoUrl;

    private String blogUrl;

}
