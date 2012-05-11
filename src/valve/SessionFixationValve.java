/*
 * commercetools GmbH
 * 
 * Copyright (c) 2006 commercetools
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of commercetools
 * ("Confidential Information").  You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with commercetools.
 */
package valve;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.catalina.Manager;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

/**
 * This valve changes the session ID. It does not destroy the previous session,
 * rather it renames it so it is no longer found by that ID.
 * 
 * @author sven mueller
 * @version $Revision:$
 */
public class SessionFixationValve extends ValveBase {

	@Override
	public void invoke(Request request, Response response) throws IOException, ServletException {
		if (request.getSessionInternal() != null) {

			// get manager, needed to rename session
			Manager manager = request.getContext().getManager();

			// get existing session session
			Session session = request.getSessionInternal();

			// "rename" existing session
			manager.changeSessionId(session);

			// set session id to request
			request.changeSessionId(session.getId());
		}
	}

}

/*
 * $Log$
 */