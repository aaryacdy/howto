package com.kathford.howto.model;

import com.kathford.howto.constant.DefaultValue;
import com.kathford.howto.util.Strings;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    public User(Long id) {
        this.setId(id);
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(nullable = false)
    private String salt;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;

    @Column(columnDefinition = DefaultValue.BOOLEAN_INACTIVE)
    private boolean blocked;

    @Column(columnDefinition = DefaultValue.BOOLEAN_ACTIVE)
    private boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = Strings.DATE_TIME_PATTERN)
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = Strings.DATE_TIME_PATTERN)
    @Column(name = "modified_date", insertable = false)
    private Date modifiedDate;
}
