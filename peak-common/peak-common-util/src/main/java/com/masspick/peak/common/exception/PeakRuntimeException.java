/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.masspick.peak.common.exception;

/**
 * Service层公用的Exception.
 * <p/>
 * 继承自RuntimeException, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 *
 * @author calvin
 */
public class PeakRuntimeException extends RuntimeException {

    /**
     *  日志.
     */
    private static final long serialVersionUID = 1401593546385403720L;

    /**
     *  ServiceException.
     */
    public PeakRuntimeException() {
        super();
    }

    /**
     *  ServiceException(String).
     *  @param message
     */
    public PeakRuntimeException(String message) {
        super(message);
    }

    /**
     *  ServiceException(Throwable).
     *  @param cause
     */
    public PeakRuntimeException(Throwable cause) {
        super(cause);
    }

    /**
     *  ServiceException(String,Throwable).
     *  @param message
     *  @param cause
     */
    public PeakRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
