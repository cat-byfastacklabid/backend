package cat.kepolisian.controller;

import cat.kepolisian.dto.answer.InsertHistoryAnswerDtoReq;
import cat.kepolisian.dto.answer.InsertHistoryAnswerDtoRes;
import cat.kepolisian.service.HistoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kepolisian/api/v1/cat-answer")
@Tag(name = "answers")
public class AnswerController {
    private final HistoryService historyService;

    @Autowired
    public AnswerController(HistoryService historyService){
        this.historyService = historyService;
    }

    @PostMapping("kepribadian")
    public ResponseEntity<InsertHistoryAnswerDtoRes> insertAnswerKepribadian(@RequestBody @Validated InsertHistoryAnswerDtoReq data) throws Exception{
        InsertHistoryAnswerDtoRes insertData = historyService.insertAnswerKepribadian(data);
        return new ResponseEntity<>(insertData, HttpStatus.CREATED);
     }

    @PostMapping("akademik")
    public ResponseEntity<InsertHistoryAnswerDtoRes> insertAnswerAkademik(@RequestBody @Validated InsertHistoryAnswerDtoReq data) throws Exception{
        InsertHistoryAnswerDtoRes insertData = historyService.insertAnswerAkademik(data);
        return new ResponseEntity<>(insertData, HttpStatus.CREATED);
    }

    @PostMapping("ketahanan")
    public ResponseEntity<InsertHistoryAnswerDtoRes> insertAnswerKetahanan(@RequestBody @Validated InsertHistoryAnswerDtoReq data) throws Exception{
        InsertHistoryAnswerDtoRes insertData = historyService.insertAnswerKetahanan(data);
        return new ResponseEntity<>(insertData, HttpStatus.CREATED);
    }
}
