package cat.kepolisian.entity;

import cat.kepolisian.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "history")
public class History extends BaseEntity {
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "question_type_id", nullable = false)
    private QuestionType questionType;
}
