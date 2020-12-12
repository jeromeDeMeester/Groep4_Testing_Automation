package controller;

import domain.model.Maaltijd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Register extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try{
            String naam = request.getParameter("naam");

            String prijs = request.getParameter("prijs");
            Double Dprijs = Double.parseDouble(prijs);

            String type = request.getParameter("type");

            //vegetarisch unfinished, weet niet hoe dit af te maken
            String vegetarisch = request.getParameter("vegetarisch");
            Boolean Bvegetarisch = Boolean.parseBoolean(vegetarisch);

            //needs to be done properly, just maybe a dellimiter?
            String allergenen = request.getParameter("allergenen");
            ArrayList<String> lallergenen = new ArrayList<>();
            lallergenen.add(allergenen);

            service.add(new Maaltijd(naam, Dprijs, type, Bvegetarisch, lallergenen));
            return "Controller?command=OverviewMaaltijden";
        }
        catch(Error e){
                return "register.jsp";
            }
        }
    }
