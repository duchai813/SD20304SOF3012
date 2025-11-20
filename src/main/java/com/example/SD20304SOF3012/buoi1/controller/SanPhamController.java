package com.example.SD20304SOF3012.buoi1.controller;

import com.example.SD20304SOF3012.buoi1.repository.SanPhamRespository;
import com.example.SD20304SOF3012.buoi4.model.GiangVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SanPhamController", value = {
        "/buoi2/hien-thi",
        "/buoi2/view-update",
        "/buoi2/xoa"
})
public class SanPhamController extends HttpServlet {

    private final SanPhamRespository sanPhamRepository = new SanPhamRespository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if (url.contains("hien-thi")) {
            hienThi(req, resp);
        } else if (url.contains("view-update")) {
            chiTiet(req, resp);
        } else if (url.contains("xoa")) {
            xoa(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSanpham", sanPhamRepository.findAll());
        req.getRequestDispatcher("/buoi2/hien-thi.jsp").forward(req, resp);
    }

    private void chiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sanPham", sanPhamRepository.getByID(id));
        req.getRequestDispatcher("/buoi2/view-update.jsp").forward(req, resp);
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        sanPhamRepository.xoaSanPham(id);
        resp.sendRedirect("/buoi2/hien-thi");
    }


}
