package com.co.nexos.prueba.Util;

import java.util.List;

/**
 * @author Luis Martinez
 * @since 01/2021
 * @version 1.0
 */
public class queryResult {

    private int totalRecords;
    private List<Object> list;

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

}