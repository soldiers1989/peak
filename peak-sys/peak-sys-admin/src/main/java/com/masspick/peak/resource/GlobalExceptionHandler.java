package com.masspick.peak.resource;

import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.utils.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * Created by admin on 2018/8/1 0001.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @param exception exception
     * @return ApiResponse
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handle(Exception exception) {
        LOGGER.error("error", exception);
        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum = ResultEnum.PARAMS_ERROR;
        if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) exception;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            String message = "";
            for (ConstraintViolation<?> item : violations) {
                message += item.getMessage();
            }
            return apiResponse.error(resultEnum.getCode(), message);
        } else {
            return apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        }
    }
}
