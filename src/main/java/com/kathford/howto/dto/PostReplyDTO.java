package com.kathford.howto.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class PostReplyDTO {

    private BigInteger postId;

    private String feedback;

}
