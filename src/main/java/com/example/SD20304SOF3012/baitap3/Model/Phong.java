package com.example.SD20304SOF3012.baitap3.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phong")
public class Phong {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "so_phong")
    private String soPhong;

    @Column(name = "loai_phong")
    private String loaiPhong;

    @Column(name = "gia_phong")
    private Integer giaPhong;

    @Column(name = "suc_chua")
    private Integer sucChua;

    @Column(name = "trang_thai")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "khach_san_id",referencedColumnName = "id")
    private KhachSan khachSan;
}
