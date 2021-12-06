package com.zyyu.ucp.service;

import com.zyyu.ucp.po.AdministratorPo;


public interface AdministratorService extends BaseService<AdministratorPo>{

    AdministratorPo adminLoginIn(AdministratorPo administratorPo);

}
