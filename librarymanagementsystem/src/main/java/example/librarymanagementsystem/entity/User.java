package example.librarymanagementsystem.entity;

import example.librarymanagementsystem.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;


@Entity
@Table(name = "user"
        ,indexes = {
                @Index(name = "idx_email",columnList = "email"),
                @Index(name = "idx_name_email",columnList = "email,name")
        }
)
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    @Column(name = "full_name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false , unique = true)
    private String email;

    @Column(name = "password",length = 30)
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_role",joinColumns = {
            @JoinColumn(name = "user_id")
    })
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Set<Role> role;
}
