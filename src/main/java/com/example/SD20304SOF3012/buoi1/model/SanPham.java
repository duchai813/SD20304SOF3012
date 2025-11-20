package com.example.SD20304SOF3012.buoi1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ma_sp")
    private Integer id;

    @Column(name = "ten_sp")
    private String ten_sp;

    @Column(name = "so_luong")
    private Integer so_luong;

    @Column(name="tinh_trang")
    private Boolean tinh_trang;

}
