package com.example.SD20304SOF3012.baitap3.Repository;

import com.example.SD20304SOF3012.baitap3.Model.KhachSan;
import com.example.SD20304SOF3012.baitap3.Until.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class KhachSanRepository {
    private Session session=null;

    public  KhachSanRepository(){
        session= HibernateConfig.getFACTORY().openSession();
    }
    public List<KhachSan> getAll(){
        return session.createQuery("SELECT ks from KhachSan ks").list();
    }
    public KhachSan getKhachsanbyId(Integer id){
        return session.find(KhachSan.class,id);

    }
}
