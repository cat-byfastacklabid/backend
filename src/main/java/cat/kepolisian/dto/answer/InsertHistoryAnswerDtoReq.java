package cat.kepolisian.dto.answer;

import lombok.Data;

import java.util.List;

@Data
public class InsertHistoryAnswerDtoReq {
    private List<InsertHistoryDetailAnswerDtoReq> answers;
}
