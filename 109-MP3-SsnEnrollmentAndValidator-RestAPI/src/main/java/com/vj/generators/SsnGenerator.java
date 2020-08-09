package com.vj.generators;

import java.io.Serializable;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SsnGenerator implements IdentifierGenerator {

	private static final String SEQ_QUERY = "SELECT ssn_seq.nextval FROM DUAL";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String prefix="707";
		String suffix="";
		String ssn="";
		try {
			ResultSet rs = session.connection().createStatement().executeQuery(SEQ_QUERY);
			if (rs.next()) {
				suffix =String.valueOf(rs.getInt(1));
				ssn=prefix+suffix;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return Long.parseLong(ssn);
	}

}
