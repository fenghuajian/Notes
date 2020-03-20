package com.itheima.domain;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class QueryVo {
    private Myuser user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }


    public Myuser getUser() {
        return user;
    }
    public void setUser(Myuser user) {
        this.user = user;
    }
}
