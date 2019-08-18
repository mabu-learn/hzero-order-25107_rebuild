package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.entity.Item;
import com.hzero.order.domain.repository.ItemRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

/**
 * @author fei.nie@hand-china.com
 */
@Repository
public class ItemRepositoryImpl extends BaseRepositoryImpl<Item> implements ItemRepository {
    @Override
    public Long getItemId(String itemCode) {
        Item item = new Item();
        item.setItemCode(itemCode);
        return this.selectOne(item).getItemId();
    }
}
