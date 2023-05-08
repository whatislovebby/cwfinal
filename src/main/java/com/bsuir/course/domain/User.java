package com.bsuir.course.domain;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="_user")
public class User {



    private Long id;
    @NotBlank
    private String password;

    private String firstName;

    private String lastName;

    private String phone;

    @Id
    @Column(unique=true, nullable = false)
    private String email;
    private String photos;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL) //FetchType.EAGER - роли будут загружаться вместе с пользователем
    @JoinTable(
            name = "_user_roles",
            joinColumns = @JoinColumn(name = "_user_email"),
            inverseJoinColumns = @JoinColumn(name = "role_name")
    )
    private Set<Role> roles = new HashSet<>();
    @Column
    private boolean enabled;

    @Transient
    public String getPhotosImagePath( ) {
        if(photos == null)
            return "/img/default-user.png";
        return "/user-photos/" + this.email + "/" + this.photos;
    }


}
