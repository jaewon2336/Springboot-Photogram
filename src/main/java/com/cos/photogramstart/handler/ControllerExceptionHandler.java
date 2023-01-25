package com.cos.photogramstart.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice // Exception을 낚아채는 핸들러
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class) // CustomValidationException이 발생하는 모든 오류 발생 시에 해당 함수로 넘어온다
    public CMRespDto<?> validationException(CustomValidationException e) {
        return new CMRespDto<>(-1, e.getMessage(), e.getErrorMap());
    }
}
