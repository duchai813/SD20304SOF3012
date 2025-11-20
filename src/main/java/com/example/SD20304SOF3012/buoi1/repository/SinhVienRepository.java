package com.example.SD20304SOF3012.buoi1.repository;

import com.example.SD20304SOF3012.buoi1.model.SinhVien;
import com.example.SD20304SOF3012.buoi1.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {
    private Session session = null;

    public SinhVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<SinhVien> findAll() {
        return session.createQuery("SELECT sv FROM SinhVien sv").list();
    }

    public SinhVien getById(Integer id) {
        return session.find(SinhVien.class, id);
    }

    public void addSinhVien(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.save(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void updateSinhVien(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.merge(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void deleteSinhVien(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
