package com.huawei.homework.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huawei.gts.homeworkbackend.dao.FlowInfoDao;
import com.huawei.gts.homeworkbackend.entity.FlowInfoEntity;
import com.huawei.gts.homeworkbackend.mapper.FlowInfoMapper;
import com.huawei.gts.homeworkbackend.vo.FlowInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FlowInfoServiceImpl extends ServiceImpl<FlowInfoDao, FlowInfoEntity> implements FlowInfoService {

    private FlowInfoMapper flowInfoMapper = FlowInfoMapper.INSTANCE;

    @Override
    public IPage<FlowInfoVo> findAllFlows() {
        IPage<FlowInfoEntity> pagination = new Page<>(1, -1);
        return flowInfoMapper.entitiesToVos(lambdaQuery().page(pagination));
    }

    @Override
    public FlowInfoVo findByName(String name) {
        FlowInfoEntity entity = lambdaQuery().eq(FlowInfoEntity::getFlowName,name).one();
        return flowInfoMapper.entityToVo(entity);
    }

    @Override
    public boolean saveVo(FlowInfoVo flowInfoVo) {
        FlowInfoEntity entity = flowInfoMapper.voToEntity(flowInfoVo);
        return save(entity);
    }

    @Override
    public boolean deleteByName(String name) {
        FlowInfoEntity entity = lambdaQuery().eq(FlowInfoEntity::getFlowName,name).one();
        return removeById(entity.getId());
    }

    @Override
    public boolean updateByName(FlowInfoVo flowInfoVo) {
        FlowInfoEntity entity = lambdaQuery().eq(FlowInfoEntity::getFlowName,flowInfoVo.getFlowName()).one();
        if(entity != null){
            entity.setDataFlowTypeId(flowInfoVo.getDataFlowTypeId());
            entity.setAppId(flowInfoVo.getAppId());
            entity.setPackageId(flowInfoVo.getPackageId());
            entity.setCreateUser(flowInfoVo.getCreateUser());
            entity.setUpdateUser(flowInfoVo.getUpdateUser());
            return updateById(entity);
        }
        return false;
    }


}
