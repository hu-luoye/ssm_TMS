package com.luoye_ssm.service.impl;

import com.luoye_ssm.dao.ISysLogDao;
import com.luoye_ssm.domain.SysLog;
import com.luoye_ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysLogService")
@Transactional
public class SysLogServieImpl implements ISysLogService {

    @Autowired
    ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}
