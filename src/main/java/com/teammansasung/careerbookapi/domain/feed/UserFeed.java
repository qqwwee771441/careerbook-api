package com.teammansasung.careerbookapi.domain.feed;

import com.teammansasung.careerbookapi.common.BaseEntity;
import com.teammansasung.careerbookapi.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Setter
@Getter
@Entity
public class UserFeed extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String pictures;

    @Column(nullable = false)
    private String contents;

    private int likes;

    private int comments;

    private int views;
}
