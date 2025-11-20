package com.example.SD20304SOF3012.buoi1.controller;

import com.example.SD20304SOF3012.buoi1.model.SinhVien;
import com.example.SD20304SOF3012.buoi1.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sinhVienController", value = {
        "/buoi1/hien-thi",
        "/buoi1/view-update",
        "/buoi1/them",
        "/buoi1/sua",
        "/buoi1/xoa"
})
public class SinhVienController extends HttpServlet {
    SinhVienRepository sinhVienRepository = new SinhVienRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            chiTiet(req, resp);
        } else if(uri.contains("xoa")) {
            xoa(req, resp);
        }
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        sinhVienRepository.deleteSinhVien(id);
        resp.sendRedirect("/buoi1/hien-thi");
    }

    private void chiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sinhVien", sinhVienRepository.getById(id));
        req.getRequestDispatcher("/buoi1/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSinhVien", sinhVienRepository.findAll());
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            themSinhVien(req, resp);
        } else if(uri.contains("sua")) {
            suaSinhVien(req, resp);
        }
    }

    private void suaSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        SinhVien sinhVien = new SinhVien(id, ten, tuoi, gioiTinh);

        sinhVienRepository.updateSinhVien(sinhVien);
        resp.sendRedirect("/buoi1/hien-thi");
    }

    private void themSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        SinhVien sinhVien = new SinhVien(null, ten, tuoi, gioiTinh);

        sinhVienRepository.addSinhVien(sinhVien);
        resp.sendRedirect("/buoi1/hien-thi");
    }
}
