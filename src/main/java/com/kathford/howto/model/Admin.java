package com.kathford.howto.model;

import com.kathford.howto.constant.DefaultValue;
import com.kathford.howto.util.Strings;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_admin")
@Getter
@Setter
@NoArgsConstructor
public class Admin {

    public Admin(Long id) {
        this.setId(id);
    }

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

    @Column(columnDefinition = DefaultValue.BOOLEAN_INACTIVE)
    private boolean blocked;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "mobile_no")
    private String mobileNo;

    private boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = Strings.DATE_TIME_PATTERN)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = Strings.DATE_TIME_PATTERN)
    @Column(name = "modified_date")
    private Date modifiedDate;



}
