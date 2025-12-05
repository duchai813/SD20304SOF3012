package com.example.SD20304SOF3012.baitap3.Controller;

import com.example.SD20304SOF3012.baitap3.Model.KhachSan;
import com.example.SD20304SOF3012.baitap3.Model.Phong;
import com.example.SD20304SOF3012.baitap3.Repository.KhachSanRepository;
import com.example.SD20304SOF3012.baitap3.Repository.PhongRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongController", value = {
        "/phong/hien-thi",
        "/phong/view-update",
        "/phong/update",
        "/phong/add",
        "/phong/delete,",
        "/phong/phan-trang",
        "/phong/tim-kiem"
})
public class PhongController extends HttpServlet {
    private PhongRepository phongRepository = new PhongRepository();
    private KhachSanRepository khachSanRepository = new KhachSanRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//            req.setAttribute("errorMesage","Ban phai Dang Nhap vao tai khoan");
//            resp.sendRedirect("/login");
//            return;
//        }
        String uri = req.getRequestURI();

        if (uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if (uri.contains("view-update")) {
            chiTiet(req, resp);
        } else if (uri.contains("delete")) {
            xoaPhong(req, resp);
        } else if (uri.contains("phan-trang")) {
            Phantrang(req, resp);
        }else if(uri.contains("tim-kiem")){
            Timkiemthegia(req,resp);
        }
    }

    private void Timkiemthegia(HttpServletRequest req, HttpServletResponse resp) {
        String min=Integer.valueOf(req.getParameter("giaMin"));
        String max=req.getParameter("max");
        req.setAttribute("listKhachSan", khachSanRepository.getAll());
        List<Phong> list=phongRepository.serchbyGia(min,max);
        req.setAttribute("listPhong",list);



    }

    private void Phantrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //khai bao
        int pageSize = 3;
        int pageNumber = 0;

        if (req.getParameter("pageNumber") != null) {
          //gan biem
            pageNumber = Integer.valueOf(req.getParameter("pageNumber"));
        }
        //khia bao gan du lieu
        req.setAttribute("listKhachSan", khachSanRepository.getAll());
        req.setAttribute("listPhong", phongRepository.paing(pageSize,pageNumber));
        req.setAttribute("pageNumber",pageNumber);
        req.getRequestDispatcher("/baitap3/hien-thi.jsp").forward(req,resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listPhong", phongRepository.getAll());
        req.setAttribute("listKhachSan", khachSanRepository.getAll());
        req.getRequestDispatcher("/baitap3/hien-thi.jsp").forward(req, resp);
    }

    private void chiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("listKhachSan", khachSanRepository.getAll());
        req.setAttribute("ph", phongRepository.getPhongbyId(id));
        req.getRequestDispatcher("/baitap3/view-update.jsp").forward(req, resp);
    }

    private void xoaPhong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        phongRepository.DeletePhong(id);
        resp.sendRedirect("/phong/hien-thi");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        HttpSession session = req.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//            resp.sendRedirect("/login.jsp");
//            return;
//        }
        String uri = req.getRequestURI();

        if (uri.contains("add")) {
            AddPhong(req, resp);

        } else if (uri.contains("update")) {
            UpdatePhong(req, resp);
        }
    }

    private void UpdatePhong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String soPhong = req.getParameter("soPhong");
        String loaiPhong = req.getParameter("loaiPhong");
        Integer giaPhong = Integer.valueOf(req.getParameter("giaPhong"));
        Integer sucChua = Integer.valueOf(req.getParameter("sucChua"));
        Boolean trangThai = Boolean.valueOf(req.getParameter("trangThai"));
        Integer idKhachSan = Integer.valueOf(req.getParameter("idKhachSan"));
        KhachSan khachSan = khachSanRepository.getKhachsanbyId(idKhachSan);
        Phong phong = new Phong(id, soPhong, loaiPhong, giaPhong, sucChua, trangThai, khachSan);
        phongRepository.UpdatePhong(phong);
        resp.sendRedirect("/phong/hien-thi");

    }

    private void AddPhong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String soPhong = req.getParameter("soPhong");
        String loaiPhong = req.getParameter("loaiPhong");
        Integer giaPhong = Integer.valueOf(req.getParameter("giaPhong"));
        Integer sucChua = Integer.valueOf(req.getParameter("sucChua"));
        Boolean trangThai = Boolean.valueOf(req.getParameter("trangThai"));
        Integer idKhachSan = Integer.valueOf(req.getParameter("idKhachSan"));
        KhachSan khachSan = khachSanRepository.getKhachsanbyId(idKhachSan);
        Phong phong = new Phong(null, soPhong, loaiPhong, giaPhong, sucChua, trangThai, khachSan);
        phongRepository.AddPhong(phong);
        resp.sendRedirect("/phong/hien-thi");

    }
}
