package com.cos.photogramstart.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;

@RestController
@ControllerAdvice // Exception을 낚아채는 핸들러
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class) // CustomValidationException이 발생하는 모든 오류 발생 시에 해당 함수로 넘어온다
    public String validationException(CustomValidationException e) {
        // CMRespDto, Script 비교
        // 1. 클라이언트에게 응답할 때 : Script
        // 2. 통신 : CMRespDto
        return Script.back(e.getErrorMap().toString());
    }
}
