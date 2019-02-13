package org.jfaster.test.dao;

import javax.annotation.Resource;

import org.jfaster.badger.Badger;
import org.jfaster.test.pojo.Driver;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yanpengfang
 * @create 2019-02-13 10:27 AM
 */
@Repository
public class DriverDao {

    @Resource
    private Badger badger;

    public int deleteDriverById(int driverId) {
        return badger.delete(Driver.class, driverId);
    }

}
