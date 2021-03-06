package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

import com.feth.play.module.pa.user.AuthUser;

@Entity
public class LinkedAccount extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	public String providerUserId;
	public String providerKey;
	
	
	public static LinkedAccount create(final AuthUser authUser) {
		final LinkedAccount ret = new LinkedAccount();
		ret.providerKey = authUser.getProvider();
		ret.providerUserId = authUser.getId();
		
		return ret;
	}


	public static LinkedAccount create(final LinkedAccount acc) {
		final LinkedAccount ret = new LinkedAccount();
		ret.providerKey = acc.providerKey;
		ret.providerUserId = acc.providerUserId;
		
		return ret;
	}
}