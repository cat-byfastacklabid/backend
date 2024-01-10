package cat.kepolisian.controller;

import cat.kepolisian.dto.questionoptions.GetQuestionOptionDtoRes;
import cat.kepolisian.dto.user.InsertUserDtoReq;
import cat.kepolisian.dto.user.InsertUserDtoRes;
import cat.kepolisian.service.AnswerService;
import cat.kepolisian.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kepolisian/api/v1/cat-answer")
public class AnswerController {
    private HistoryService historyService;

    @Autowired
    public AnswerController(HistoryService historyService){
        this.historyService = historyService;
    }

//    @PostMapping("kepribadian")
//    public ResponseEntity<InsertUserDtoRes> insertAnswerKepribadian(@RequestBody @Validated InsertUserDtoReq data) throws Exception{
//        InsertUserDtoRes insertData = historyService.insert(data);
//        return new ResponseEntity<>(insertData, HttpStatus.CREATED);
//    }
//
//    @PostMapping("akademik")
//    public ResponseEntity<InsertUserDtoRes> insertAnswerAkademik(@RequestBody @Validated InsertUserDtoReq data) throws Exception{
//        InsertUserDtoRes insertData = historyService.insert(data);
//        return new ResponseEntity<>(insertData, HttpStatus.CREATED);
//    }
//
//    @PostMapping("ketahanan")
//    public ResponseEntity<InsertUserDtoRes> insertAnswerKetahanan(@RequestBody @Validated InsertUserDtoReq data) throws Exception{
//        InsertUserDtoRes insertData = historyService.insert(data);
//        return new ResponseEntity<>(insertData, HttpStatus.CREATED);
//    }
}
