package cn.wq.hrm.client;

import cn.wq.hrm.domain.Department;
import cn.wq.hrm.query.DepartmentQuery;
import cn.wq.hrm.util.AjaxResult;
import cn.wq.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author wq
 * @date 2019/8/30
 */
@Component
public class DepartmentClientHystrixFallbackFactory implements FallbackFactory<DepartmentClient> {

    @Override
    public DepartmentClient create(Throwable throwable) {
        return new DepartmentClient() {
            @Override
            public AjaxResult save(Department department) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Department get(Long id) {
                return null;
            }

            @Override
            public List<Department> list() {
                return null;
            }

            @Override
            public PageList<Department> json(DepartmentQuery query) {
                return null;
            }
        };
    }
}
