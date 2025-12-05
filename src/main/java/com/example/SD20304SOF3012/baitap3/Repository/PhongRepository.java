package com.example.SD20304SOF3012.baitap3.Repository;

import com.example.SD20304SOF3012.baitap3.Model.Phong;
import com.example.SD20304SOF3012.baitap3.Until.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PhongRepository {
    private Session session=null;

    public PhongRepository(){
        session= HibernateConfig.getFACTORY().openSession();
    }
    public List<Phong> getAll(){
        return session.createQuery("SELECT ph from Phong ph").list();
    }
    public Phong getPhongbyId(Integer id){
        return session.find(Phong.class,id);
    }
    public void AddPhong(Phong phong){
        try{
            session.getTransaction().begin();
            session.save(phong);
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public void UpdatePhong(Phong phong){
        try{
            session.getTransaction().begin();
            session.merge(phong);
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public void DeletePhong(Integer id){
        try{
            session.getTransaction().begin();
            session.delete(getPhongbyId(id));
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public List<Phong> paing(int pageSize,int pageNumber){
        Query query=session.createQuery("from Phong");
        query.setFirstResult(pageNumber*pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }
    public List<Phong> serchbyGia(Integer giaMin,Integer giaMax){
        Query query=session.createQuery("From Phong ph where ph.giaPhong BETWEEN :min and :max");
        query.setParameter("min",giaMin);
        query.setParameter("max",giaMax);
       return query.list();

    }

}
