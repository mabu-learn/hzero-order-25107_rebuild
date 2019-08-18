package com.hzero.order.domain.repository;

import com.hzero.order.domain.entity.SoLine;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * @author fei.nie@hand-china.com
 */
public interface SoLineRepository extends BaseRepository<SoLine> {
    /**
     * 根据订单信息查询订单的行信息
     * @param soLine
     * @param pageRequest
     * @return
     */
    List<SoLine> selectPageLines(SoLine soLine, PageRequest pageRequest);
}
