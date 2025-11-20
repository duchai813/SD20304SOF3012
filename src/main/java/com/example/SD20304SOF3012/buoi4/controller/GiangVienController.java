package com.example.SD20304SOF3012.buoi4.controller;

        import com.example.SD20304SOF3012.buoi4.model.GiangVien;
        import com.example.SD20304SOF3012.buoi4.model.TruongHoc;
        import com.example.SD20304SOF3012.buoi4.repository.GiangVienRepository;
        import com.example.SD20304SOF3012.buoi4.repository.TruongHocRepository;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;

        import java.io.IOException;
        import java.util.List;

@WebServlet(name = "giangViencontroller", value = {
        "/giang-vien/hien-thi",
        "/giang-vien/xoa",
        "/giang-vien/view-update",
        "/giang-vien/update",
        "/giang-vien/add"
})
public class GiangVienController extends HttpServlet {

    private final TruongHocRepository truongHocRepository = new TruongHocRepository();
    private final GiangVienRepository giangVienRepository = new GiangVienRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if (url.contains("hien-thi")) {
            hienThi(req, resp);
        } else if (url.contains("view-update")) {
            chiTiet(req, resp);
        } else if (url.contains("xoa")) {
            XoaGiangVien(req, resp);
        }
    }
    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listGiangVien", giangVienRepository.getAll());
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    private void chiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.setAttribute("giangVien", giangVienRepository.getGiangVienbyId(id));
        req.getRequestDispatcher("/buoi4/view-update.jsp").forward(req, resp);
    }
    private void XoaGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.valueOf(req.getParameter("id"));
        giangVienRepository.XoaGiangVien(id);
        resp.sendRedirect("/giang-vien/hien-thi");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();
        if(uri.contains("update")){
            suaGiangVien(req,resp);
        } else if(uri.contains("add")){
            themGiangVien(req,resp);
        }
    }
    private void suaGiangVien(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten_giang_vien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioi_tinh"));
        String truongIdStr = req.getParameter("truong_id");
        GiangVien giangVien = giangVienRepository.getGiangVienbyId(id);
        giangVien.setTen_giang_vien(ten);
        giangVien.setTuoi(tuoi);
        giangVien.setGioi_tinh(gioiTinh);

        if (truongIdStr != null && !truongIdStr.isEmpty()) {
            Integer idTruong = Integer.valueOf(truongIdStr);
            TruongHoc th = truongHocRepository.getTruongHocbyID(idTruong);
            giangVien.setTruongHoc(th);
        }
        giangVienRepository.UpdateGiangVien(giangVien);
        resp.sendRedirect("/giang-vien/hien-thi");



    }


    private void themGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten =req.getParameter("ten_giang_vien");
        Integer tuoi=Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh=Boolean.valueOf(req.getParameter("gioi_tinh"));
        String truongIdStr = req.getParameter("id_truong");
        TruongHoc th = null;
        if (truongIdStr != null && !truongIdStr.isEmpty()) {
            Integer idTruonghoc = Integer.valueOf(truongIdStr);
            th = truongHocRepository.getTruongHocbyID(idTruonghoc);
        }
        GiangVien giangVien=new GiangVien(null,ten,tuoi,gioiTinh,th);
        giangVienRepository.addGiangVien(giangVien);
        resp.sendRedirect("/giang-vien/hien-thi");
    }

}
