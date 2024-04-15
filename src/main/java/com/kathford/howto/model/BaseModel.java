package com.kathford.howto.model;

import com.kathford.howto.util.Strings;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @OneToOne
    @JoinColumn(name = "modified_by", insertable = false)
    private User modifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = Strings.DATE_TIME_PATTERN)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = Strings.DATE_TIME_PATTERN)
    @Column(name = "modified_date")
    private Date modifiedDate;

}
