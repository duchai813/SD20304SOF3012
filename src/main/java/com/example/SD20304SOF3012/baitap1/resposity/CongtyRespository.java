package com.example.SD20304SOF3012.baitap1.resposity;

import com.example.SD20304SOF3012.baitap1.model.CongTy;

import com.example.SD20304SOF3012.baitap1.until.HibernateConfig;
import org.hibernate.Session;

import java.util.List;


public class CongtyRespository {
    private Session session = null;

    public CongtyRespository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<CongTy> getAll() {
        return session.createQuery("select ct from CongTy ct").list();

    }

    public CongTy getCongtybyId(Integer id) {
        return session.find(CongTy.class, id);
    }

}
