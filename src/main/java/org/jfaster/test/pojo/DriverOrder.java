package org.jfaster.test.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.jfaster.badger.query.annotations.Column;
import org.jfaster.badger.query.annotations.Id;
import org.jfaster.badger.query.annotations.ShardColumn;
import org.jfaster.badger.query.annotations.ShardTable;
import org.jfaster.badger.query.shard.TableShardStrategy;

import lombok.Data;

/**
 *
 * @author yanpengfang
 * @create 2019-02-11 4:00 PM
 */
@ShardTable(tables = {"driver_order_0", "driver_order_1"},
        tableShardStrategy = DriverOrder.OrderTableShardStrategy.class)
@Data
public class DriverOrder {

    @Id
    @Column
    private String orderNo;

    @Column
    private BigDecimal money;

    @ShardColumn
    @Column
    private int driverId;

    @Column
    private Date createDate;

    @Column
    private Date updateDate;

    public static class OrderTableShardStrategy implements TableShardStrategy<Integer> {
        @Override
        public String shardSingle(List<String> tables, Integer shardValue) {
            int mod = shardValue % 2;
            for (String table : tables) {
                if (table.endsWith("_" + mod)) {
                    return table;
                }
            }
            return tables.get(0);
        }
    }
}

