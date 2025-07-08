package com.example.fabrick.exeptions;

public class WrongParamitersExeption extends Exception{

    public WrongParamitersExeption(String parameters){
        super(parameters+" è obbligatorio");
    }



    public WrongParamitersExeption(String parameter, String message){
        super("il paramtro "+parameter+"è sbaglaito perche "+ message);
    }
}
