package com.example.SD20304SOF3012.buoi4.repository;

import com.example.SD20304SOF3012.buoi4.model.TruongHoc;

import com.example.SD20304SOF3012.buoi4.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class TruongHocRepository {
    private Session session=null;
    public TruongHocRepository(){
        session= HibernateConfig.getFACTORY().openSession();

    }
    public List<TruongHoc> getAll(){
        return session.createQuery("SELECT th FROM TruongHoc th", TruongHoc.class).list();
    }
    public TruongHoc getTruongHocbyID(Integer id){
        return session.find(TruongHoc.class,id);
    }
}
