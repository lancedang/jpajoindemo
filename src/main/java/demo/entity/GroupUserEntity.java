package demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "group_user", schema = "hackweek")
public class GroupUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "group_id", nullable = false)
    private Long groupId;

    // 首先在插入数据的时候, user 信息中的 userId(主键) 会默认存到 groupuser 表中 name 对应的column(这个column需要在表中建好)
    // 若想使user 表中除了 userId 主键之外的比如 userNumber 存入 groupuser 中, 则加入 referenceColumnName 字段指定user_number 列
    // name 表示存入 groupuser 表中的字段名,
    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name = "user_number", referencedColumnName = "user_number")
    private UserInfoEntity userInfo;

}
