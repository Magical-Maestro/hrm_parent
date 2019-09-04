package cn.wq.hrm.query;

/**
 * 基础模块:分页高级查询对象
 */
public class BaseQuery {
    //关键字
    private String keyword;
    /*
    * 分页公共属性
    *   page:当前页
    *   rows:每页数据条数
    * */
    private Integer page = 1;
    private Integer rows = 10;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /*public Integer getStart(){
        return (this.page-1)*rows;
    }*/

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
