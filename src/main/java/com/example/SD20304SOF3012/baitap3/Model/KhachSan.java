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
@Table(name = "khach_san")
public class KhachSan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "ten_khach_san")
    private String tenKhachsan;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_sao")
    private Integer soSao;

    @Column(name = "so_dien_thoai")
    private String soDienthoai;


}
