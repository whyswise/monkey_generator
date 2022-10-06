package com.monkey.generator.controller.exception;

import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monkey.generator.model.ResponseModel;

@ApiIgnore
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

    @GetMapping(value = "/entrypoint")
    public ResponseModel entrypointException() {
        throw new CAuthenticationEntryPointException();
    }
}