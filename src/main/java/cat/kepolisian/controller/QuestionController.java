package cat.kepolisian.controller;

import cat.kepolisian.dto.questionoptions.GetQuestionOptionDtoRes;
import cat.kepolisian.service.AnswerService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kepolisian/api/v1/cat-test")
@Tag(name = "questions")
public class QuestionController {
    private final AnswerService answerService;

    @Autowired
    public QuestionController(AnswerService answerService){
        this.answerService = answerService;
    }

    @GetMapping("kepribadian")
    public ResponseEntity<GetQuestionOptionDtoRes> getQuestionKepribadian() throws Exception{
        GetQuestionOptionDtoRes getQuestionKepribadian = answerService.getQuestionKepribadian();
        return new ResponseEntity<>(getQuestionKepribadian, HttpStatus.OK);
    }

    @GetMapping("akademik")
    public ResponseEntity<GetQuestionOptionDtoRes> getQuestionAkademik() throws Exception{
        GetQuestionOptionDtoRes getQuestionAkademik = answerService.getQuestionAkademik();
        return new ResponseEntity<>(getQuestionAkademik, HttpStatus.OK);
    }

    @GetMapping("ketahanan")
    public ResponseEntity<GetQuestionOptionDtoRes> getQuestionKetahanan() throws Exception{
        GetQuestionOptionDtoRes getQuestionKetahanan = answerService.getQuestionKetahanan();
        return new ResponseEntity<>(getQuestionKetahanan, HttpStatus.OK);
    }
}
