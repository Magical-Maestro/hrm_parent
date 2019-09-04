package cn.wq.hrm.service.impl;

import cn.wq.hrm.domain.Employee;
import cn.wq.hrm.domain.Tenant;
import cn.wq.hrm.mapper.EmployeeMapper;
import cn.wq.hrm.mapper.TenantMapper;
import cn.wq.hrm.service.ITenantService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wq
 * @since 2019-09-02
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private TenantMapper tenantMapper;
    @Override
    public boolean insert(Tenant tenant) {
        System.out.println(tenant.getId());
        tenant.setRegisterTime(new Date());
        tenant.setState(false);
        //添加机构
        tenantMapper.insert(tenant);
        System.out.println(tenant.getId());
        //添加管理员
        Employee adminUser = tenant.getAdminUser();
        //输入时间
        adminUser.setInputTime(new Date());
        // 正常
        adminUser.setState(0);
        //是否是租户管理员
        adminUser.setType(true);
        adminUser.setTenantId(tenant.getId());
        employeeMapper.insert(adminUser);
        //添加套餐中间表
        tenantMapper.saveTenantMeals(tenant.getMealsMap());
        return true;
    }

    @Override
    public boolean deleteById(Serializable id) {

        //删除机构
        tenantMapper.deleteById(id);
        //删除管理员
        Wrapper<Employee> wapper = new EntityWrapper<>();
        wapper.eq("tenant_id",id);
        employeeMapper.delete(wapper);
        //删除中间表
        tenantMapper.removeTenantMeal(id);
        return true;
    }

    @Override
    public boolean updateById(Tenant tenant) {
        // 修改机构
        tenantMapper.updateById(tenant);
        //修改管理员
        employeeMapper.updateById(tenant.getAdminUser());
        //修改中间表-先删除后添加
        tenantMapper.removeTenantMeal(tenant.getId());
        tenantMapper.saveTenantMeals(tenant.getMealsMap());
        return true;
    }
}
