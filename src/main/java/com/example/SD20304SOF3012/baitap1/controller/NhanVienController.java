package com.example.SD20304SOF3012.baitap1.controller;

import com.example.SD20304SOF3012.baitap1.model.CongTy;
import com.example.SD20304SOF3012.baitap1.model.NhanVien;
import com.example.SD20304SOF3012.baitap1.resposity.CongtyRespository;
import com.example.SD20304SOF3012.baitap1.resposity.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "NhanVienController", value = {"/nhan-vien/hien-thi",
        "/nhan-vien/view-update", "/nhan-vien/delete", "/nhan-vien/add", "/nhan-vien/update","/nhan-vien/paging","/nhan-vien/search"})
public class NhanVienController extends HttpServlet {
    NhanVienRepository nhanVienRepository = new NhanVienRepository();//khai bao reposity
    CongtyRespository congtyRespository = new CongtyRespository();

    //KHAI BAO DOGET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            Hienthi(req, resp);

        } else if (uri.contains("view-update")) {
            Chitiet(req, resp);
        } else if (uri.contains("delete")) {
            DeleteNhanvien(req, resp);

        } else if ((uri.contains("paging"))) {
            paging(req,resp);
        } else if ((uri.contains("search"))) {
            search(req,resp);
        }


    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenNhanvien=req.getParameter("tenNhanvien");
        req.setAttribute("listCongty",congtyRespository.getAll());
        req.setAttribute("listNhanvien",nhanVienRepository.searchbyName(tenNhanvien));
        req.getRequestDispatcher("/baitap/hien-thi.jsp").forward(req,resp);
    }

    public void paging(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        int pageSize=3;
        int pageNumber=0;
        if(req.getParameter("pageNumber")!=null){
            pageNumber=Integer.valueOf(req.getParameter("pageNumber"));
        }
        req.setAttribute("listCongty",congtyRespository.getAll());
        req.setAttribute("listNhanvien",nhanVienRepository.paing(pageNumber,pageSize));
        req.setAttribute("pageNumber",pageNumber);
        req.getRequestDispatcher("/baitap/hien-thi.jsp").forward(req, resp);
    }

    private void Hienthi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listCongty", congtyRespository.getAll());
        req.setAttribute("listNhanvien", nhanVienRepository.getAll());
        req.getRequestDispatcher("/baitap/hien-thi.jsp").forward(req, resp);
    }

    private void Chitiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("listCongty", congtyRespository.getAll());
        req.setAttribute("nv", nhanVienRepository.getNhanvienbyID(id));
        req.getRequestDispatcher("/baitap/view-update.jsp").forward(req, resp);
    }

    private void DeleteNhanvien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        nhanVienRepository.deleteNhanvien(id);
        resp.sendRedirect("/nhan-vien/hien-thi");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            addNhanVien(req, resp);

        } else if (uri.contains("update")) {
            UpdateNhanVien(req, resp);
        }
    }

    private void addNhanVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenNhanvien = req.getParameter("tenNhanvien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        Integer idCongty = Integer.valueOf(req.getParameter("idCongty"));
        CongTy congTy = congtyRespository.getCongtybyId(idCongty);

        NhanVien nhanVien = new NhanVien(null, tenNhanvien, tuoi, gioiTinh, congTy);
        nhanVienRepository.addNhanvien(nhanVien);
        resp.sendRedirect("/nhan-vien/hien-thi");


    }

    private void UpdateNhanVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenNhanvien = req.getParameter("tenNhanvien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        Integer idCongty = Integer.valueOf(req.getParameter("idCongty"));
        CongTy congTy = congtyRespository.getCongtybyId(idCongty);

        NhanVien nhanVien = new NhanVien(id, tenNhanvien, tuoi, gioiTinh, congTy);
        nhanVienRepository.UpdateNhanvien(nhanVien);
        resp.sendRedirect("/nhan-vien/hien-thi");


    }
}
