package main.demo.mvc.controller.basement;

public abstract class BaseController<T> {
    protected final T service;

    protected BaseController(T service) {
        this.service = service;
    }
}
