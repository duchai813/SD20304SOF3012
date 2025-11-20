package com.example.SD20304SOF3012.baitap1.resposity;

import com.example.SD20304SOF3012.baitap1.model.NhanVien;
import com.example.SD20304SOF3012.baitap1.until.HibernateConfig;
import org.hibernate.query.Query;
import org.hibernate.Session;
import java.util.List;


public class NhanVienRepository {
    private Session session = null;

    public NhanVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();

    }

    public List<NhanVien> getAll() {
        return session.createQuery("select nv from NhanVien nv").list();
    }
    public NhanVien getNhanvienbyID(Integer id){
        return session.find(NhanVien.class,id);
    }
    public void deleteNhanvien(Integer id){
        try{
            session.getTransaction().begin();
            session.delete(this.getNhanvienbyID(id));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public void addNhanvien(NhanVien nhanVien){
        try{
            session.getTransaction().begin();
            session.save(nhanVien);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public void UpdateNhanvien(NhanVien nhanVien){
        try{
            session.getTransaction().begin();
            session.merge(nhanVien);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public List<NhanVien> paing(int pageNumber,int pageSize){
       Query query=session.createQuery("from NhanVien ");
       query.setFirstResult(pageNumber*pageSize);
       query.setMaxResults(pageSize);
       return query.list();


    }
    public List<NhanVien> searchbyName(String tenNhanvien){
        Query query=session.createQuery("SELECT nv from NhanVien nv where nv.tenNhanvien like:tenNhanvien");
        query.setParameter("tenNhanvien","%"+tenNhanvien+"%");
        return query.list();

    }

}
