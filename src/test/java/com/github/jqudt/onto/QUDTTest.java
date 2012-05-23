/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.openrdf.model.URI;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFParseException;

public class QUDTTest {

	@Test
	public void testUnitOntology() throws RepositoryException, RDFParseException, IOException {
		URI symbol = QUDT.SYMBOL;
		Assert.assertEquals(QUDT.namespace, symbol.getNamespace());
		Assert.assertEquals("symbol", symbol.getLocalName());
	}

}
