package cat.kepolisian.service.impl;

import cat.kepolisian.constant.QuestionTypeEnum;
import cat.kepolisian.core.BaseServiceImpl;
import cat.kepolisian.dao.AnswerDao;
import cat.kepolisian.dao.QuestionDao;
import cat.kepolisian.dao.QuestionTypeDao;
import cat.kepolisian.dto.questionoptions.GetQuestionOptionDtoDataRes;
import cat.kepolisian.dto.questionoptions.GetQuestionOptionDtoRes;
import cat.kepolisian.dto.questionoptions.GetOptionsFromQuestionDtoDataRes;
import cat.kepolisian.entity.Answer;
import cat.kepolisian.entity.Question;
import cat.kepolisian.entity.QuestionType;
import cat.kepolisian.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl extends BaseServiceImpl implements AnswerService {
    private AnswerDao answerDao;
    private QuestionDao questionDao;
    private QuestionTypeDao questionTypeDao;

    @Autowired
    public AnswerServiceImpl(AnswerDao answerDao, QuestionDao questionDao, QuestionTypeDao questionTypeDao){
        this.answerDao = answerDao;
        this.questionDao = questionDao;
        this.questionTypeDao = questionTypeDao;
    }

    @Override
    public GetQuestionOptionDtoRes getQuestionKepribadian() throws Exception {
        GetQuestionOptionDtoRes getQuestionKepribadian = new GetQuestionOptionDtoRes();

        QuestionType questionType = questionTypeDao.getByTypeCode(QuestionTypeEnum.KEPRIBADIAN.getCode());

        List<Question> listQuestion = questionDao.getByQuestionType(questionType);
        List<GetOptionsFromQuestionDtoDataRes> listAnswerFromQuestion = new ArrayList<>();

        for(int i = 0; i < listQuestion.size(); i++ ) {
            Question question = listQuestion.get(i);
            GetOptionsFromQuestionDtoDataRes answerFromQuestion = new GetOptionsFromQuestionDtoDataRes();

            List<Answer> listAnswer = answerDao.getByQuestionId(question.getId());
            List<GetQuestionOptionDtoDataRes> listAnswerData = new ArrayList<>();
            for (int j = 0; j < listAnswer.size(); j++){
                Answer answer = listAnswer.get(j);
                GetQuestionOptionDtoDataRes answerData = new GetQuestionOptionDtoDataRes();

                answerData.setId(answer.getId());
                answerData.setName(answer.getName());
                answerData.setValue(answer.getValue());

                listAnswerData.add(answerData);
            }

            answerFromQuestion.setOptions(listAnswerData);
            answerFromQuestion.setQuestionId(question.getId());
            answerFromQuestion.setQuestion(question.getQuestion());

            listAnswerFromQuestion.add(answerFromQuestion);
        }

        getQuestionKepribadian.setQuizTitle("Test Kepribadian");
        getQuestionKepribadian.setQuestion(listAnswerFromQuestion);

        return getQuestionKepribadian;
    }

    @Override
    public GetQuestionOptionDtoRes getQuestionAkademik() throws Exception {
        GetQuestionOptionDtoRes getQuestionAkademik = new GetQuestionOptionDtoRes();

        QuestionType questionType = questionTypeDao.getByTypeCode(QuestionTypeEnum.AKADEMIK.getCode());

        List<Question> listQuestion = questionDao.getByQuestionType(questionType);
        List<GetOptionsFromQuestionDtoDataRes> listAnswerFromQuestion = new ArrayList<>();

        for(int i = 0; i < listQuestion.size(); i++ ) {
            Question question = listQuestion.get(i);
            GetOptionsFromQuestionDtoDataRes answerFromQuestion = new GetOptionsFromQuestionDtoDataRes();

            List<Answer> listAnswer = answerDao.getByQuestionId(question.getId());
            List<GetQuestionOptionDtoDataRes> listAnswerData = new ArrayList<>();
            for (int j = 0; j < listAnswer.size(); j++){
                Answer answer = listAnswer.get(j);
                GetQuestionOptionDtoDataRes answerData = new GetQuestionOptionDtoDataRes();

                answerData.setId(answer.getId());
                answerData.setName(answer.getName());
                answerData.setValue(answer.getValue());

                listAnswerData.add(answerData);
            }

            answerFromQuestion.setOptions(listAnswerData);
            answerFromQuestion.setQuestionId(question.getId());
            answerFromQuestion.setQuestion(question.getQuestion());

            listAnswerFromQuestion.add(answerFromQuestion);
        }

        getQuestionAkademik.setQuizTitle("Test Kepribadian");
        getQuestionAkademik.setQuestion(listAnswerFromQuestion);

        return getQuestionAkademik;
    }

    @Override
    public GetQuestionOptionDtoRes getQuestionKetahanan() throws Exception {
        GetQuestionOptionDtoRes getQuestionKetahanan = new GetQuestionOptionDtoRes();

        QuestionType questionType = questionTypeDao.getByTypeCode(QuestionTypeEnum.KETAHANAN.getCode());

        List<Question> listQuestion = questionDao.getByQuestionType(questionType);
        List<GetOptionsFromQuestionDtoDataRes> listAnswerFromQuestion = new ArrayList<>();

        for(int i = 0; i < listQuestion.size(); i++ ) {
            Question question = listQuestion.get(i);
            GetOptionsFromQuestionDtoDataRes answerFromQuestion = new GetOptionsFromQuestionDtoDataRes();

            List<Answer> listAnswer = answerDao.getByQuestionId(question.getId());
            List<GetQuestionOptionDtoDataRes> listAnswerData = new ArrayList<>();
            for (int j = 0; j < listAnswer.size(); j++){
                Answer answer = listAnswer.get(j);
                GetQuestionOptionDtoDataRes answerData = new GetQuestionOptionDtoDataRes();

                answerData.setId(answer.getId());
                answerData.setName(answer.getName());
                answerData.setValue(answer.getValue());

                listAnswerData.add(answerData);
            }

            answerFromQuestion.setOptions(listAnswerData);
            answerFromQuestion.setQuestionId(question.getId());
            answerFromQuestion.setQuestion(question.getQuestion());

            listAnswerFromQuestion.add(answerFromQuestion);
        }

        getQuestionKetahanan.setQuizTitle("Test Kepribadian");
        getQuestionKetahanan.setQuestion(listAnswerFromQuestion);

        return getQuestionKetahanan;
    }
}
