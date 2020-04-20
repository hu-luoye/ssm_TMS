package com.luoye_ssm.dao;

import com.luoye_ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 会员数据持久层接口
 */
@Repository("memberDao")
public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    public Member findById(int id) throws Exception;
}
