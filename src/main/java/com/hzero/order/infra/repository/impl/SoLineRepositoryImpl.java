package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.entity.SoLine;
import com.hzero.order.domain.repository.SoLineRepository;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
@Repository
public class SoLineRepositoryImpl extends BaseRepositoryImpl<SoLine> implements SoLineRepository {
    @Override
    public List<SoLine> selectPageLines(SoLine soLine, PageRequest pageRequest) {
        return PageHelper.doPage(pageRequest, () -> new SoLineRepositoryImpl().select(soLine));
    }

}
