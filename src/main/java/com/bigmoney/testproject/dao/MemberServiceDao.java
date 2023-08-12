package com.bigmoney.testproject.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigmoney.testproject.security.CustomUserDetails;

@Repository
public class MemberServiceDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public CustomUserDetails loginID(String m_id) {
        return sqlSessionTemplate.selectOne("member.loginID", m_id);
    }

    public Map<String, Object> getMember(String m_id) {
        return sqlSessionTemplate.selectOne("member.getMember", m_id);
    }

    public Integer updateMember(Map<String, Object> map) {
        return sqlSessionTemplate.update("member.updateMember", map);
    }

    public Map<String, Object> getBuy(String b_id) {
        return sqlSessionTemplate.selectOne("member.getBuy", b_id);
    }

    public Map<String, Object> getSold(String s_id) {
        return sqlSessionTemplate.selectOne("member.getSold", s_id);
    }

    public List<Map<String, Object>> getSoldList(int m_number) {
        return sqlSessionTemplate.selectList("member.getSoldList", m_number);
    }

    public List<Map<String, Object>> getBuyList(int m_number) {
        return sqlSessionTemplate.selectList("member.getBuyList", m_number);
    }

    public Integer regist(Map<String, Object> map) {
        return sqlSessionTemplate.insert("member.regist", map);
    }
}