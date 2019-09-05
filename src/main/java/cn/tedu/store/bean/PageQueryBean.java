package cn.tedu.store.bean;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * ��ҳʵ����
 * 
 * @author Peng
 * @Date2016��12��13�� ����9:40:10
 */
public class PageQueryBean {
	 
    private static final int DEFAULT_PAGE_SIZE = 10;
    /** ��ǰҳ */
    private Integer currentPage;
    /** ÿҳ��ʾ�������� */
    private Integer pageSize;
    /** ���м�¼�� */
    private int totalRows;
    /** sql��ѯ��ʼ�� */
    private Integer startRow;
    /** ��ҳ�� */
    private Integer totalPage;
    /** ��ѯ�������ݼ� */
    private List<Map<String, Object>> items;
 
 
 
 
    public final Integer getStartRow() {
        if (startRow == null)
            startRow = (currentPage == null ? 0 : (currentPage - 1) * getPageSize()) ;
        return startRow;
    }
 
 
    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
 
    public final Integer getPageSize() {
        return pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
    }
 
    public final void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
 
    public final int getTotalRows() {
        return totalRows;
    }
 
    public final void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        int totalPage = totalRows % getPageSize() == 0 ? totalRows / getPageSize() : totalRows / getPageSize() + 1;
        setTotalPage(totalPage);
    }
 
    public final List<Map<String, Object>> getItems() {
        return items == null ? Collections.EMPTY_LIST : items;
    }
 
    public final void setItems(List<Map<String, Object>> items) {
        this.items = items;
    }
 
    public final Integer getCurrentPage() {
        return currentPage;
    }
 
    public final void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
 
    public final Integer getTotalPage() {
        return totalPage == null || totalPage == 0 ? 1 : totalPage;
    }
 
    public final void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
 
 
    @Override
    public String toString() {
        return "PageQueryBean [currentPage=" + currentPage + ", pageSize="
                + pageSize + ", totalRows=" + totalRows + ", startRow="
                + startRow + ", totalPage=" + totalPage + ", items=" + items
                + "]";
    }
 
}