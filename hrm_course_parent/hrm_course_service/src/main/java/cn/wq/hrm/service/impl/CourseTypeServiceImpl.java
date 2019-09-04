package cn.wq.hrm.service.impl;

import cn.wq.hrm.domain.CourseType;
import cn.wq.hrm.mapper.CourseTypeMapper;
import cn.wq.hrm.query.CourseTypeQuery;
import cn.wq.hrm.service.ICourseTypeService;
import cn.wq.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author wq
 * @since 2019-08-31
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {
    @Autowired
    private CourseTypeMapper courseTypeMapper;
    /*
     * 高级查询+分页+关联查询
     * */
    @Override
    public PageList<CourseType> selectListPage(CourseTypeQuery query) {
        Page page = new Page(query.getPage(),query.getRows()); //Page extends Pagination
        List<CourseType> courseTypes = courseTypeMapper.loadListPage(page, query);
        return new PageList<>(page.getTotal(),courseTypes);
    }
}
