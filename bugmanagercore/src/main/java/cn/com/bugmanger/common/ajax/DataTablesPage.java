package cn.com.bugmanger.common.ajax;

import cn.com.bugmanger.mybatis.model.Page;

/**
 * Created by fcs on 2015/3/23.
 */
public class DataTablesPage extends Page {
    private int draw;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
