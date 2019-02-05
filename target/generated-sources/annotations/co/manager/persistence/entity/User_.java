package co.manager.persistence.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> surname;
	public static volatile SingularAttribute<User, Date> lastUpdate;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> username;

}

