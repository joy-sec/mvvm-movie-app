package dev.hellojoy.moviemvvm.utils;


public class DataState<T> {

    public Status status;
    public T data;
    public String message;

    public DataState(Status status) {
        this.status = status;
    }
    public DataState(Status status, String message) {
        this.status = status;
        this.message = message;
    }
    public DataState(Status status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> DataState<T> SUCCESS(T data){
        return new DataState<>(Status.SUCCESS, data);
    }
    public static <T> DataState<T> LOADING(){
        return new DataState<>(Status.LOADING);
    }
    public static <T> DataState<T> ERROR(String message){
        return new DataState<>(Status.ERROR, message);
    }

}
