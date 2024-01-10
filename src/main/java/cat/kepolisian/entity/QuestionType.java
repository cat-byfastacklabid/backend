package cat.kepolisian.entity;

import cat.kepolisian.core.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "question_type")
public class QuestionType extends BaseEntity {
    @Column(name = "type_code")
    private String typeCode;
    @Column(name = "type_name")
    private String typeName;
}
