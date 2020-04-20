package com.luoye_ssm.service;

import com.luoye_ssm.domain.SysLog;

/**
 * 日志业务层
 */
public interface ISysLogService {

    void save(SysLog sysLog) throws Exception;
}
