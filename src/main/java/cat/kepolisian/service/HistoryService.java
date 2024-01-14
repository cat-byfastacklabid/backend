package cat.kepolisian.service;

import cat.kepolisian.dto.answer.InsertHistoryAnswerDtoReq;
import cat.kepolisian.dto.answer.InsertHistoryAnswerDtoRes;

public interface HistoryService {
    public InsertHistoryAnswerDtoRes insertAnswerKepribadian(InsertHistoryAnswerDtoReq data) throws Exception;
    public InsertHistoryAnswerDtoRes insertAnswerAkademik(InsertHistoryAnswerDtoReq data) throws Exception;
    public InsertHistoryAnswerDtoRes insertAnswerKetahanan(InsertHistoryAnswerDtoReq data) throws Exception;

}
