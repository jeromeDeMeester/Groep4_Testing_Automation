package controller;

import domain.service.MaaltijdService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {

    protected MaaltijdService service = MaaltijdService.getInstance();

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);

    public void setModel (MaaltijdService contactTracingService) {
        this.service = contactTracingService;
    }

    public MaaltijdService getService() {
        return service;
    }

}
