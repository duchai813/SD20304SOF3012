    package com.example.SD20304SOF3012.buoi4.repository;

    import com.example.SD20304SOF3012.buoi4.model.GiangVien;
    import com.example.SD20304SOF3012.buoi4.util.HibernateConfig;
    import org.hibernate.Session;

    import java.util.List;

    public class GiangVienRepository {
        private Session session=null;
        public GiangVienRepository(){
            session= HibernateConfig.getFACTORY().openSession();
        }
        public List<GiangVien> getAll(){
            return session.createQuery("select gv from GiangVien gv").list();
        }
        public GiangVien getGiangVienbyId(Integer id){
            return session.find(GiangVien.class,id);


        }
        public void addGiangVien(GiangVien giangVien){
            try{
                session.getTransaction().begin();
                session.merge(giangVien);
                session.getTransaction().commit();

            }catch (Exception e){
                e.printStackTrace();
                session.getTransaction().rollback();
            }
        }
        public void UpdateGiangVien(GiangVien giangVien){
            try{
                session.getTransaction().begin();
                session.update(giangVien);
                session.getTransaction().commit();

            }catch (Exception e){
                e.printStackTrace();
                session.getTransaction().rollback();
            }
        }
        public void XoaGiangVien(Integer id){
            try{
                session.getTransaction().begin();
                session.delete(this.getGiangVienbyId(id));
                session.getTransaction().commit();

            }catch (Exception e){
                e.printStackTrace();
                session.getTransaction().rollback();
            }
        }
    }
