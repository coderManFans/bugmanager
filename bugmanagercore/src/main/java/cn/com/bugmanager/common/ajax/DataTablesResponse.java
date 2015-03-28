package cn.com.bugmanager.common.ajax;
import java.util.List;
/**
 * Created by fcs on 2015/3/23.
 */
public class DataTablesResponse {
    private  List data;
    private int recordsTotal;
    private int recordsFiltered;
    private int draw;

    public DataTablesResponse(DataTablesPage dataTablesPage ,List data){
        if(dataTablesPage != null){
            this.recordsTotal = dataTablesPage.getTotalResult();
            this.recordsFiltered =dataTablesPage.getTotalResult();
            this.draw = dataTablesPage.getDraw();
        }
        this.data = data;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
