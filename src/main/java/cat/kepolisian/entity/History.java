package cat.kepolisian.entity;

import cat.kepolisian.core.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "history")
public class History extends BaseEntity {
}
