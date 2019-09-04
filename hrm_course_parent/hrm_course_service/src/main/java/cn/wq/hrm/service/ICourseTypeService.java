package cn.wq.hrm.service;

import cn.wq.hrm.domain.CourseType;
import cn.wq.hrm.query.CourseTypeQuery;
import cn.wq.hrm.util.PageList;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author wq
 * @since 2019-08-31
 */
public interface ICourseTypeService extends IService<CourseType> {
    /*
     * 高级查询+分页+关联查询
     * */
    PageList<CourseType> selectListPage(CourseTypeQuery query);
}
