package com.kathford.howto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_keyword")
@Getter
@Setter
public class Keyword {

    @Id
    @GeneratedValue
    private Long id;

    private String questions;

}
