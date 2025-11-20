package com.example.SD20304SOF3012.buoi1.repository;

import com.example.SD20304SOF3012.buoi1.model.SanPham;
import com.example.SD20304SOF3012.buoi1.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRespository {
    private Session session=null;
    public SanPhamRespository(){
        session= HibernateConfig.getFACTORY().openSession();
    }
    public List<SanPham> findAll(){
        return session.createQuery("Select sp FROM SanPham sp").list();
    }
    public SanPham getByID(Integer id){
        return session.find(SanPham.class,id);
    }
    public void addSanPham(SanPham sanPham){
        try{
            session.getTransaction().begin();
            session.save(sanPham);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public void UpdateSanPham(SanPham sanPham){
        try{
            session.getTransaction().begin();
            session.merge(sanPham);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public void xoaSanPham(Integer id){
        try{
            session.getTransaction().begin();
            session.delete(this.getByID(id));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
