package com.kathford.howto.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_admin")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String salt;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private String address;

    private String role;

    @Column(name = "phone_no", nullable = false)
    private String phoneNo;

    @Column(name = "mobile_no")
    private String mobileNo;

    private boolean status;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

}
