package org.jfaster.test.dao;

import javax.annotation.Resource;

import org.jfaster.badger.Badger;
import org.jfaster.test.pojo.Driver;
import org.jfaster.test.pojo.DriverOrder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yanpengfang
 * @create 2019-02-13 10:27 AM
 */
@Repository
public class DriverOrderDao {

    @Resource
    private Badger badger;

    public int deleteDriverOrderByOrderNo(String orderNo) {
        return badger.delete(DriverOrder.class, orderNo);
    }

}
