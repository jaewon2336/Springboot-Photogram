package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;

@RestController
@ControllerAdvice // Exception을 낚아채는 핸들러
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class) // RuntimeException이 발생하는 모든 오류 발생 시에 해당 함수로 넘어온다
    public Map<String, String> validationException(CustomValidationException e) {
        return e.getErrorMap();
    }
}
