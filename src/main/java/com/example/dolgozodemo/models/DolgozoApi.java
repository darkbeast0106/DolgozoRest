package com.example.dolgozodemo.models;

import com.example.dolgozodemo.ApiRoutes;
import com.example.dolgozodemo.core.RequestHandler;
import com.example.dolgozodemo.core.Response;
import com.google.gson.Gson;

import java.util.List;

public class DolgozoApi {
    private static final Gson converter = new Gson();
    public static List<Dolgozo> getDolgozok() throws Exception {
        String url = ApiRoutes.DolgozoRoutes.GET_ALL;
        Response response = RequestHandler.getRequest(url);
        DolgozoApiValasz valasz = converter.fromJson(response.getContent(), DolgozoApiValasz.class);
        if (valasz.isError()){
            throw new Exception(valasz.getMessage());
        }
        return valasz.getAdatok();
    }

    public static boolean deleteDolgozo(int id) throws Exception{
        String url = String.format(ApiRoutes.DolgozoRoutes.DELETE,id);
        Response response = RequestHandler.deleteRequest(url);
        DolgozoApiValasz valasz = converter.fromJson(response.getContent(), DolgozoApiValasz.class);
        if (valasz.isError()){
            throw new Exception(valasz.getMessage());
        }
        return true;
    }

    public static Dolgozo insertDolgozo(String nev, String nem, int kor, int fizetes) throws Exception {
        String url = ApiRoutes.DolgozoRoutes.POST;
        Dolgozo dolgozo = new Dolgozo(0, nev, nem, kor, fizetes);
        Response response = RequestHandler.postRequestJSON(url, converter.toJson(dolgozo));
        DolgozoApiValasz valasz = converter.fromJson(response.getContent(), DolgozoApiValasz.class);
        if (valasz.isError()){
            throw new Exception(valasz.getMessage());
        }
        int id = valasz.getAdatok().get(0).getId();
        dolgozo.setId(id);
        return dolgozo;
    }

    public static Dolgozo updateDolgozo(int id, String nev, String nem, int kor, int fizetes) throws Exception {
        Dolgozo dolgozo = new Dolgozo(id, nev, nem, kor, fizetes);
        String url = String.format(ApiRoutes.DolgozoRoutes.PUT,id);
        Response response = RequestHandler.putRequestJSON(url,converter.toJson(dolgozo));
        DolgozoApiValasz valasz = converter.fromJson(response.getContent(), DolgozoApiValasz.class);
        if (valasz.isError()){
            throw new Exception(valasz.getMessage());
        }
        return dolgozo;
    }
}
