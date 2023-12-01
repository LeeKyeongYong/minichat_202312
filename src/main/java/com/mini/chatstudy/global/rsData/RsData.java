package com.mini.chatstudy.global.rsData;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RsData<T>{
    private String resultCode;
    private String msg;
    private T data;

    public static <T> RsData<T> of(String resultCode, String msg, T data) {
        return new RsData<>(resultCode, msg, data);
    }

    public static <T> RsData<T> of(String resultCode, String msg) {
        return of(resultCode, msg, null);
    }

    public boolean isSucces(){
        return resultCode.startsWith("S-");
    }

    public boolean isFail(){
        return !isSucces();
    }

    public Optional<RsData<T>> optional(){
        return Optional.of(this);
    }

    public <T> RsData<T> newDataOf(T data) {
        return new RsData<T>(getResultCode(),getMsg(),data);
    }
}
