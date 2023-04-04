package com.zzx.model.vo;

import com.zzx.model.base.BaseEntity;

public class SysUserQueryVo extends BaseEntity {
    private static final long serialVersionUID=1L;
    private String userName;
    private String createTimeBegin;
    private String createTimeEnd;
    private String keyWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKeyWord() {
        return  keyWord;
    }

    public String getCreateTimeBegin() {
        return createTimeBegin;
    }

    public void setCreateTimeBegin(String createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
