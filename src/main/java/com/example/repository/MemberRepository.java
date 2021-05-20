package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final String TABLE_MEMBERS = "members";

	private RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));
		return member;
	};

	public List<Member> findByName(String name) {

		String sql = "SELECT id,name,age,dep_id FROM " + TABLE_MEMBERS + " WHERE name LIKE :name;";
		String ambiguousName = "%" + name + "%";
		System.out.println(ambiguousName);
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", ambiguousName);
		List<Member> members = template.query(sql, param, MEMBER_ROW_MAPPER);
		System.out.println(members);
		return members;
	}
}
