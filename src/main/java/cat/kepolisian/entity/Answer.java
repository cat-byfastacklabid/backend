package cat.kepolisian.entity;

import cat.kepolisian.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "answer")
public class Answer extends BaseEntity {
    @Column(name = "answer")
    private String name;
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
