package HelloApp;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Client {

	public static void main(String[] args) {
		try {
			Properties env = System.getProperties();
			env.put("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
			env.put("java.naming.provider.url", "iiop://localhost:900");
			Context context = new InitialContext(env);

			Object ref = context.lookup("Hello");

			Hello stub = HelloHelper.narrow((org.omg.CORBA.Object) ref);

			System.out.println(stub.sayHello());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}