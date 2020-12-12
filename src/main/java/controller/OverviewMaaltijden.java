package controller;

import domain.service.MaaltijdService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OverviewMaaltijden extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("maaltijden", MaaltijdService.getInstance().getMaaltijden());
        return "maaltijden.jsp";
    }
}
