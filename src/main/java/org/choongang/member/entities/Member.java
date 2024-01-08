package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.choongang.commons.entities.Base;
import org.choongang.file.entities.FileInfo;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member extends Base {
    @Id @GeneratedValue
    private Long seq;

    @Column(length = 65, nullable = false)
    private String gid;

    @Column(length=80, nullable = false, unique = true)
    private String email;

    @Column(length=40, nullable = false, unique = true)
    private String userId;

    @Column(length=65, nullable = false)
    private String password;

    @Column(length=40, nullable = false)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Authorities> authorities = new ArrayList<>();

//    @Transient
//    private String profileImagePath;
//    @Transient
//    private String profileImageUrl;

    //위에 2개는 아래 하나에 다 포함 되있기 떄문에 삭제
    @Transient
    private FileInfo profileImage;
}
