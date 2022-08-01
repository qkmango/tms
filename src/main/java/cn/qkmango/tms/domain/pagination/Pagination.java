package cn.qkmango.tms.domain.pagination;


/**
 * 分页实体类，包含当前页码page、每页条数limit、略过的记录条数
 */
public class Pagination {

    protected Integer page = 1;
    protected Integer limit = 20;
    protected Integer skipCount = 0;
    //默认就是分页
    protected Boolean pagination = true;

    public Pagination() {
    }

    public Pagination(Integer page, Integer limit, Boolean pagination) {
        this.page = page;
        this.limit = limit;
        this.skipCount = (page-1)*limit;
        this.pagination = pagination;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.skipCount = (page-1)*limit;
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.skipCount = (page-1)*limit;
        this.limit = limit;
    }

    public Integer getSkipCount() {
        return skipCount;
    }

    public void setSkipCount() {
        this.skipCount = (page-1)*limit;
    }

    public Boolean getPagination() {
        return pagination;
    }

    public void setPagination(Boolean pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "page=" + page +
                ", limit=" + limit +
                ", skipCount=" + skipCount +
                ", pagination=" + pagination +
                '}';
    }
}
