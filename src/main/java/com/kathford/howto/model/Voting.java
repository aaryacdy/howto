package com.kathford.howto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_voting")
@Getter
@Setter
public class Voting extends BaseModel {

    private Integer rating;
}
