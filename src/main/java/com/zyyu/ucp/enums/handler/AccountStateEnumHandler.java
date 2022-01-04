package com.zyyu.ucp.enums.handler;

import com.zyyu.ucp.enums.AccountStateEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Java枚举AccountStateEnum自动转换，存取数据库
 */
@MappedTypes(value = AccountStateEnum.class)
public class AccountStateEnumHandler implements TypeHandler<AccountStateEnum> {

    @Override
    public AccountStateEnum getResult(ResultSet rs, String column) throws SQLException {
        return AccountStateEnum.valueOf(rs.getInt(column));
    }

    @Override
    public AccountStateEnum getResult(ResultSet rs, int i) throws SQLException {
        return AccountStateEnum.valueOf(rs.getInt(i));
    }

    @Override
    public AccountStateEnum getResult(CallableStatement cs, int i) throws SQLException {
        return AccountStateEnum.valueOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, AccountStateEnum accountStateEnum, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte) accountStateEnum.ordinal());
    }

}