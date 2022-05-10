package com.acme.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class ResultEnvelope<T> {


    private final boolean success;
    private final Integer code;
    private final Date created_at;
    private final String request_id;
    private final T data;


    private final Map<String,String> metadata;
    private final List<ApiError> errors;

    public static <T>ResultEnvelope ok(T data){
        return new ResultEnvelope(true,200,new Date(), UUID.randomUUID().toString(),data,null,null);

    }
    public static <T>ResultEnvelope fail(Integer code, List<ApiError> errors) {

        return new ResultEnvelope(false,code,new Date(), UUID.randomUUID().toString(),null,null,errors);
    }

    public static <T>ResultEnvelope fail(ApiError apiError) {
        return new ResultEnvelope(false,apiError.getCode(),new Date(), UUID.randomUUID().toString(),null, null,List.of(apiError));

    }
}
