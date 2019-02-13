package org.jfaster.test.service.impl;

import javax.annotation.Resource;

import org.jfaster.test.dao.DriverDao;
import org.jfaster.test.dao.DriverOrderDao;
import org.jfaster.test.service.DriverOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yanpengfang
 * @create 2019-02-13 10:37 AM
 */
@Service
public class DriverOrderServiceImpl implements DriverOrderService {

    @Resource
    private DriverDao driverDao;

    @Resource
    private DriverOrderDao driverOrderDao;

    @Override
    @Transactional
    public boolean deleteDriverAndOrder(int driverId, String orderNo) {
        return driverDao.deleteDriverById(driverId) > 0
                && driverOrderDao.deleteDriverOrderByOrderNo(orderNo) > 0;
    }
}
