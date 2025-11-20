package com.example.SD20304SOF3012.buoi4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "giang_vien")
public class GiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_giang_vien")
    private String ten_giang_vien;

    @Column(name = "tuoi")
    private Integer tuoi;

    @Column(name="gioi_tinh")
    private Boolean gioi_tinh;

    @ManyToOne
    @JoinColumn(name = "truong_id", referencedColumnName = "id")
    private TruongHoc truongHoc;


}
