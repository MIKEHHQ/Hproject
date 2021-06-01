package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.Namelist;

public interface NamelistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Namelist record);

    int insertSelective(Namelist record);

    Namelist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Namelist record);

    int updateByPrimaryKey(Namelist record);
}