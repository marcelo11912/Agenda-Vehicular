package com.agendaVehicular.util.paginador;

import org.springframework.data.domain.Page;

public class PageRender<T> {

    private String url;
    private Page<T> page;
    private int totalPage;
    private int numPage;
    private int paginaActual;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        numPage = page.getSize();
        totalPage = page.getTotalPages();
        paginaActual = page.getNumber()+1;
        int desde, hasta;
        if (totalPage <= numPage) {
            desde = 1;
            hasta = totalPage;
        }else{
            if(paginaActual <= numPage/2){
            
            }
        }

    }

}

