package cat.kepolisian.service.impl;

import cat.kepolisian.constant.QuestionTypeEnum;
import cat.kepolisian.core.BaseServiceImpl;
import cat.kepolisian.dao.*;
import cat.kepolisian.dto.answer.InsertHistoryAnswerDtoDataRes;
import cat.kepolisian.dto.answer.InsertHistoryAnswerDtoReq;
import cat.kepolisian.dto.answer.InsertHistoryAnswerDtoRes;
import cat.kepolisian.dto.answer.InsertHistoryDetailAnswerDtoReq;
import cat.kepolisian.entity.*;
import cat.kepolisian.service.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl extends BaseServiceImpl implements HistoryService {

    private final UserDao userDao;
    private final QuestionTypeDao typeDao;
    private final QuestionDao questionDao;
    private final AnswerDao answerDao;
    private final HistoryDao historyDao;
    private final HistoryDetailDao detailDao;
    private Double tempValue = 0.0;
    private static final String SUCCESS_MSG = "Answer successfully created";

    @Autowired
    public HistoryServiceImpl(UserDao userDao, QuestionTypeDao typeDao, QuestionDao questionDao, AnswerDao answerDao, HistoryDao historyDao, HistoryDetailDao detailDao){
        this.userDao = userDao;
        this.typeDao = typeDao;
        this.questionDao = questionDao;
        this.answerDao = answerDao;
        this.historyDao = historyDao;
        this.detailDao = detailDao;
    }

    @Override
    public InsertHistoryAnswerDtoRes insertAnswerKepribadian(InsertHistoryAnswerDtoReq data) throws Exception {
        InsertHistoryAnswerDtoRes insert = new InsertHistoryAnswerDtoRes();

        History history = new History();

        QuestionType questionType = typeDao.getByTypeCode(QuestionTypeEnum.KEPRIBADIAN.getCode());
        history.setQuestionType(questionType);

        history.setCreatedBy(getId());
        History insertHistory = historyDao.save(history);

        List<InsertHistoryDetailAnswerDtoReq> listDetailAnswer = data.getAnswers();
        for (InsertHistoryDetailAnswerDtoReq detailAnswer : listDetailAnswer) {
            HistoryDetail detail = new HistoryDetail();

            detail.setHistory(insertHistory);

            Question question = questionDao.getById(detailAnswer.getQuestion());
            detail.setQuestion(question);

            Answer answer = answerDao.getById(detailAnswer.getOption());
            detail.setAnswer(answer);
            detail.setValue(answer.getValue());

            Integer answerValue = Integer.parseInt(answer.getValue());
            addValue(answerValue);

            detail.setCreatedBy(getId());
            detailDao.save(detail);
        }

        InsertHistoryAnswerDtoDataRes dataRes = new InsertHistoryAnswerDtoDataRes();

        User user = userDao.getById(insertHistory.getCreatedBy());
        dataRes.setUsername(user.getUsername());

        double value = tempValue / 5;
        dataRes.setValue(Double.toString(value));

        insert.setMsg(SUCCESS_MSG);
        insert.setData(dataRes);

        return insert;
    }

    @Override
    public InsertHistoryAnswerDtoRes insertAnswerAkademik(InsertHistoryAnswerDtoReq data) throws Exception {
        InsertHistoryAnswerDtoRes insert = new InsertHistoryAnswerDtoRes();

        History history = new History();

        QuestionType questionType = typeDao.getByTypeCode(QuestionTypeEnum.AKADEMIK.getCode());
        history.setQuestionType(questionType);

        history.setCreatedBy(getId());
        History insertHistory = historyDao.save(history);

        List<InsertHistoryDetailAnswerDtoReq> listDetailAnswer = data.getAnswers();
        for (InsertHistoryDetailAnswerDtoReq detailAnswer : listDetailAnswer) {
            HistoryDetail detail = new HistoryDetail();

            detail.setHistory(insertHistory);

            Question question = questionDao.getById(detailAnswer.getQuestion());
            detail.setQuestion(question);

            Answer answer = answerDao.getById(detailAnswer.getOption());
            detail.setAnswer(answer);
            detail.setValue(answer.getValue());

            boolean answerValue = Boolean.parseBoolean(answer.getValue());
            addValue(answerValue);

            detail.setCreatedBy(getId());
            detailDao.save(detail);
        }

        InsertHistoryAnswerDtoDataRes dataRes = new InsertHistoryAnswerDtoDataRes();

        User user = userDao.getById(insertHistory.getCreatedBy());
        dataRes.setUsername(user.getUsername());

        double value = (tempValue / 5) * 100;
        dataRes.setValue(Double.toString(value));

        insert.setMsg(SUCCESS_MSG);
        insert.setData(dataRes);

        return insert;
    }

    @Override
    public InsertHistoryAnswerDtoRes insertAnswerKetahanan(InsertHistoryAnswerDtoReq data) throws Exception {
        InsertHistoryAnswerDtoRes insert = new InsertHistoryAnswerDtoRes();

        History history = new History();

        QuestionType questionType = typeDao.getByTypeCode(QuestionTypeEnum.KETAHANAN.getCode());
        history.setQuestionType(questionType);

        history.setCreatedBy(getId());
        History insertHistory = historyDao.save(history);

        List<InsertHistoryDetailAnswerDtoReq> listDetailAnswer = data.getAnswers();
        for (InsertHistoryDetailAnswerDtoReq detailAnswer : listDetailAnswer) {
            HistoryDetail detail = new HistoryDetail();

            detail.setHistory(insertHistory);

            Question question = questionDao.getById(detailAnswer.getQuestion());
            detail.setQuestion(question);

            Answer answer = answerDao.getById(detailAnswer.getOption());
            detail.setAnswer(answer);
            detail.setValue(answer.getValue());

            boolean answerValue = Boolean.parseBoolean(answer.getValue());
            addValue(answerValue);

            detail.setCreatedBy(getId());
            detailDao.save(detail);
        }

        InsertHistoryAnswerDtoDataRes dataRes = new InsertHistoryAnswerDtoDataRes();

        User user = userDao.getById(insertHistory.getCreatedBy());
        dataRes.setUsername(user.getUsername());

        double value = (tempValue / 5) * 100;
        dataRes.setValue(Double.toString(value));

        insert.setMsg(SUCCESS_MSG);
        insert.setData(dataRes);

        return insert;
    }

    private void addValue(Integer data){
        tempValue = tempValue + data;
    }

    private void addValue(boolean data){
        if(data){
            tempValue = tempValue + 1;
        }
    }
}