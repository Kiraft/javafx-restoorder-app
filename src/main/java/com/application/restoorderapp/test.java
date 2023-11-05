package com.application.restoorderapp;

import com.application.restoorderapp.models.Orden;
import com.application.restoorderapp.models.repositories.OrdenRepositoryImplement;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        OrdenRepositoryImplement ori = new OrdenRepositoryImplement();

        List<Orden> ordens = ori.listar();

        for (Orden ordenes: ordens) {
            System.out.println(ordenes);
        }
    }
}
