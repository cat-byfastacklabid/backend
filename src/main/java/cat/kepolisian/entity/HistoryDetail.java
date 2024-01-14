package cat.kepolisian.entity;

import cat.kepolisian.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "history_detail")
public class HistoryDetail extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "historyId", nullable = false)
    private History history;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;
    @Column(name = "value")
    private String value;
}
