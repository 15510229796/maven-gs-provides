package com.jk.gs.service.user;

import com.jk.gs.mapper.user.UserMapper;
import com.jk.gs.model.user.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<RoleBean> getRole() {
        return userMapper.getRole();
    }

    public void addRole(RoleBean role) {
        role.setNewtime(new Date());
        userMapper.addRole(role);
    }

    public void updRole(RoleBean role) {
        role.setNewtime(new Date());
        userMapper.updRole(role);
    }

    public void delRole(String ids) {
        userMapper.delRole(ids);
    }

    public List<TreeBean> getZtree() {
        return userMapper.getZtree();
    }

    public List<RoleTree> getPowerById(Integer rid) {
        return userMapper.getPowerById(rid);
    }

    public Boolean addRoleTree(Integer id, String ids) {
        try {
            userMapper.delRoleTree(id);
            String[] treeId = ids.split(",");
            ArrayList<RoleTree> list = new ArrayList<RoleTree>();
            for (String ss : treeId) {
                RoleTree roleTrees = new RoleTree();
                roleTrees.setTid(Integer.parseInt(ss));
                roleTrees.setRid(id);
                list.add(roleTrees);
            }
            userMapper.addRoleTree(list);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Power> getPower(Integer id) {
        return userMapper.getPower(id);
    }

    public void addMenu(Power menu) {
        userMapper.addMenu(menu);
    }

    public void delMenu(Integer id) {
        userMapper.delMenu(id);
    }

    public void updMenu(Power menu) {
        userMapper.updMenu(menu);
    }

    public void addTree(TreeBean tr) {
        tr.setPid(tr.getId());
        userMapper.addTree(tr);
    }

    public void updTree(TreeBean tr) {
        userMapper.updTree(tr);
    }

    public void delTree(Integer id) {
        userMapper.delTree(id);
    }

    public List<TreeBean> getTreees(Integer id) {

        return userMapper.getTreees(id);
    }

    public List<Resources> getFileList(Integer userId, Integer id) {
        return userMapper.getFileList(userId,id);
    }

    public boolean uploadPhotoFiles(ArrayList<Resources> resourse) {
        try{
            userMapper.uploadPhotoFiles(resourse);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<HashMap> getFileLists(Integer userid, String idss) {
        String idnull = "";
        String idn = "";
        String ids = "";
        String shengid = "";
        String newid = "";
        //先用idss和id 匹配 查询出数据
        List<Resources> list = userMapper.getFileTypeById(idss);
        //循环数据 判断type是否为空
        for (Resources bean : list) {
            //如果为空 用id 匹配 pid 查询
            if (bean.getType() == null) {
                if (bean.getPid() != -1) {
                    idnull += "," + bean.getId();
                    idn = idnull.substring(1);
                    //调用循环方法 递归
                    shengid = getFileById(idn);
                }
            } else {
                ids += "," + bean.getId();
            }
        }
        if(ids==""&& shengid != null){
            newid = shengid.substring(1);
        }else if(shengid == null&& ids!="" ){
            newid = ids.substring(1);
        }else if(ids=="" && shengid == null){
            return null;
        }else{
            if(shengid == ""){
                newid = ids.substring(1);
            }else{
                newid = ids.substring(1) + "," + shengid.substring(1);
            }

        }

        System.out.println(newid);
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        ArrayList<Resources> resourceBeans = new ArrayList<Resources>();
        stringObjectHashMap.put("userid", userid);
        stringObjectHashMap.put("id", newid);
        //System.out.println(stringObjectHashMap.get("id"));

        List<HashMap> alllist = userMapper.getFileLista(stringObjectHashMap);
        return alllist;
    }

    public String getFileById(String idn) {
        String idnull = "";
        String idnn = "";
        String ids = "";
        //用id 匹配 pid 查询出 lis 数据集合
        List<Resources> lis = userMapper.getFileTypeByPid(idn);
        //如果集合里面有数据
        if (lis.size() > 0) {
            //循环集合lis
            for (Resources li : lis) {
                if (li.getType() == null) {
                    //如果类型为空 将id做为参数 递归调用自身
                    idnull += "," + li.getId();
                    idnn = idnull.substring(1);
                    //调用自身
                    getFileById(idnn);
                } else {
                    ids += "," + li.getId();
                }
            }
            return ids;
        } else {
            //如果集合里面 没有数据
            return null;
        }
    }

    public void addFolder(Resources resourse) {
        userMapper.addFolder(resourse);
    }

    public List<Log> getLogByPage(Integer page, Integer rows) {
        page=(page-1)*rows;
        return userMapper.getLogByPage(page,rows);
    }

    public List<Log> getLog() {
        return userMapper.getLog();
    }

    public List<Notice> getNoticeByPage(Integer page, Integer rows) {
        page=(page-1)*rows;
        return userMapper.getNoticeByPage(page,rows);
    }

    public List<Notice> getNotice() {
        return userMapper.getNotice();
    }

    public void addNotice(Notice notice) {
        notice.setTime(new Date());
        userMapper.addNotice(notice);
    }

    public List<Clientele> getClientele() {
        return userMapper.getClientele();
    }

    public List<Clientele> getClienteleByPage(Integer page, Integer rows) {
        page=(page-1)*rows;
        return userMapper.getClienteleByPage(page,rows);
    }

    public void addClientele(Clientele clientele) {
        userMapper.addClientele(clientele);
    }

    public void updClientele(Clientele clientele) {
        userMapper.updClientele(clientele);
    }

    public void delClientele(String ids) {
        userMapper.delClientele(ids);
    }

    public List<Rental> getRental(Rental rental) {
        return userMapper.getRental(rental);
    }

    public List<Rental> getRentalByPage(Rental rental,Integer page, Integer rows) {
        page=(page-1)*rows;
        return userMapper.getRentalByPage(rental,page,rows);
    }

    public void addRental(Rental rental) {
        userMapper.addRental(rental);
    }

    public boolean uploadPhotoFile(ArrayList<Photos> photos) {
        try{
            userMapper.uploadPhotoFile(photos);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public List<Photos> getPhotos(String hid) {
        return userMapper.getPhotos(hid);
    }

    public List<Rental> getRentalByClientele(Integer id, Integer page, Integer rows) {
        page=(page-1)*rows;
        return userMapper.getRentalByClientele(id,page,rows);
    }

    public void delRental(String ids) {
        userMapper.delRental(ids);
    }

    public void updRental(Rental rental) {
        userMapper.updRental(rental);
    }

    public List<Rental> getRentals(Rental rental) {

        return userMapper.getRentals(rental);
    }

    public List<Rental> getRentalByPages(Rental rental, Integer page, Integer rows) {
        page=(page-1)*rows;
        return userMapper.getRentalByPages(rental,page,rows);
    }

    public List<Clientele> getEmail() {
        return userMapper.getEmail();
    }

}
