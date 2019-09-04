package cn.wq.hrm.service.impl;

import cn.wq.hrm.domain.Permission;
import cn.wq.hrm.mapper.PermissionMapper;
import cn.wq.hrm.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wq
 * @since 2019-09-02
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
