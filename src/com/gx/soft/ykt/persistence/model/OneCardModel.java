package com.gx.soft.ykt.persistence.model;

import com.gx.soft.ykt.persistence.domain.OneCardPersonDetail;

import java.util.List;

public class OneCardModel {
    private List<OneCardPersonDetail> oneCardList;

    public OneCardModel(List<OneCardPersonDetail> oneCardList) {
        this.oneCardList = oneCardList;
    }

    public OneCardModel() {
    }

    public List<OneCardPersonDetail> getOneCardList() {
        return oneCardList;
    }

    public void setOneCardList(List<OneCardPersonDetail> oneCardList) {
        this.oneCardList = oneCardList;
    }
}
