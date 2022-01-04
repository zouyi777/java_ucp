package com.zyyu.ucp.service;

import com.zyyu.ucp.model.po.AdministratorPo;


public interface AdministratorService extends BaseService<AdministratorPo>{

    AdministratorPo adminLoginIn(AdministratorPo administratorPo);

}
