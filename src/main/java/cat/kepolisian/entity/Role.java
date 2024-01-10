package cat.kepolisian.entity;

import cat.kepolisian.core.BaseEntity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_role")
public class Role extends BaseEntity {
    @Column(name = "role_code", length = 5, nullable = false, unique = true)
    private String roleCode;
    @Column(name = "role_name", length = 30, nullable = false)
    private String roleName;
}
