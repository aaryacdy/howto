package com.kathford.howto.model;

import com.kathford.howto.constant.DefaultValue;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.Strings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_post")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    public Post(Long id) {
        this.setId(id);
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 5000)
    private String description;

    @Column(name = "youtube_url")
    private String youtubeUrl;

    @Column
    private String image;

    @Column(name = "blog_url")
    private String blogUrl;  //in case if any blog is already posted in other website

    private String document;

    @Column(columnDefinition = DefaultValue.BOOLEAN_ACTIVE)
    private boolean status;

    @Column(name = "post_status", columnDefinition = "varchar(50) default 'Pending'")
    private String postStatus;   //

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "created_by")
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

    @OneToOne
    @JoinColumn(name = "created_by_admin_id")
    private Admin createdByAdmin;

    @OneToOne
    @JoinColumn(name = "modified_by_admin_id")
    private Admin modifiedByAdmin;
}
