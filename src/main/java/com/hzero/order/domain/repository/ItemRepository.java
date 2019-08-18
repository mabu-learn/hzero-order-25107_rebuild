package com.hzero.order.domain.repository;

import com.hzero.order.domain.entity.Item;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;

/**
 * @author fei.nie@hand-china.com
 */
public interface ItemRepository extends BaseRepository<Item> {
    /**
     * 根据物料编码得到物料ID
     * @param itemCode
     * @return
     */
    Long getItemId(String itemCode);
}
