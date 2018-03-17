package demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_info", schema = "hackweek")
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long userId;

    @Column(name = "user_number")
    private Long userNumber;

    @Column(name = "name")
    private String userName;

    //@OneToOne(mappedBy = "userInfo")
    //private GroupUserEntity groupUser;
}
