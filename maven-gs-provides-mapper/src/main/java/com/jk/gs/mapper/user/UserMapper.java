package com.jk.gs.mapper.user;

import com.jk.gs.model.user.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public interface UserMapper  {
    List<RoleBean> getRole();

    void addRole(RoleBean role);

    void updRole(RoleBean role);

    void delRole(@Param("ids") String ids);

    List<TreeBean> getZtree();

    List<RoleTree> getPowerById(Integer rid);

    void delRoleTree(Integer id);

    void addRoleTree(@Param("list") ArrayList<RoleTree> list);

    List<Power> getPower(Integer id);

    void addMenu(Power menu);

    void delMenu(Integer id);

    void updMenu(Power menu);

    void addTree(TreeBean tr);

    void updTree(TreeBean tr);

    void delTree(Integer id);

    List<TreeBean> getTreees(Integer id);

    List<Resources> getFileList(@Param("userId") Integer userId, @Param("id")Integer id);

    void uploadPhotoFiles(ArrayList<Resources> resourse);

    List<Resources> getFileTypeById(@Param("idss")String idss);

    List<HashMap> getFileLista(HashMap<String, Object> stringObjectHashMap);

    List<Resources> getFileTypeByPid(@Param("idn")String idn);

    void addFolder(Resources resourse);

    List<Log> getLog();

    List<Log> getLogByPage(@Param("page") Integer page,@Param("rows") Integer rows);

    List<Notice> getNoticeByPage(@Param("page")Integer page, @Param("rows")Integer rows);

    List<Notice> getNotice();

    void addNotice(Notice notice);

    List<Clientele> getClienteleByPage(@Param("page")Integer page, @Param("rows")Integer rows);

    List<Clientele> getClientele();

    void addClientele(Clientele clientele);

    void updClientele(Clientele clientele);

    void delClientele(@Param("ids") String ids);

    List<Rental> getRental(@Param("rental") Rental rental);

    List<Rental> getRentalByPage(@Param("rental") Rental rental,@Param("page") Integer page,@Param("rows") Integer rows);

    void addRental(Rental rental);

    void uploadPhotoFile(ArrayList<Photos> photos);

    List<Photos> getPhotos(String hid);

    List<Rental> getRentalByClientele( @Param("id") Integer id, @Param("page") Integer page,@Param("rows") Integer rows);

    void delRental(@Param("ids")String ids);

    void updRental(Rental rental);

    List<Rental> getRentals(@Param("rental")Rental rental);

    List<Rental> getRentalByPages(@Param("rental") Rental rental,@Param("page") Integer page,@Param("rows") Integer rows);

    List<Clientele> getEmail();
}
