package com.kathford.howto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_post_reply")
@Getter
@Setter
public class PostReply {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(length = 5000)
    private String reply;

}
