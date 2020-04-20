package com.luoye_ssm.dao;

import com.luoye_ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 日志dao层
 */
public interface ISysLogDao {

    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,methon) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{methon})")
    public void save(SysLog sysLog) throws Exception;
}
