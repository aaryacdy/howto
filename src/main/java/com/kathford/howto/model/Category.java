package com.kathford.howto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_category")
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseAdminModel {

    public Category(Long id) {
        super.setId(id);
    }

    private String name;

    @Column(columnDefinition = "boolean default 0")
    private boolean status;
}
