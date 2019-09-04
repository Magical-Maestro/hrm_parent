package cn.wq.hrm.client;

import cn.wq.hrm.domain.Menu;
import cn.wq.hrm.query.MenuQuery;
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
public class MenuClientHystrixFallbackFactory implements FallbackFactory<MenuClient> {

    @Override
    public MenuClient create(Throwable throwable) {
        return new MenuClient() {
            @Override
            public AjaxResult save(Menu menu) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Menu get(Long id) {
                return null;
            }

            @Override
            public List<Menu> list() {
                return null;
            }

            @Override
            public PageList<Menu> json(MenuQuery query) {
                return null;
            }
        };
    }
}
