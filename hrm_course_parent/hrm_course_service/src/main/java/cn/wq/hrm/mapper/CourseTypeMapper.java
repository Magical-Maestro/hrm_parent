package cn.wq.hrm.mapper;

import cn.wq.hrm.domain.CourseType;
import cn.wq.hrm.query.CourseTypeQuery;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程目录 Mapper 接口
 * </p>
 *
 * @author wq
 * @since 2019-08-31
 */
public interface CourseTypeMapper extends BaseMapper<CourseType> {
    /*
    * 高级查询+分页+关联查询
    * */
    List<CourseType> loadListPage(Page page, @Param("query") CourseTypeQuery query);
}
