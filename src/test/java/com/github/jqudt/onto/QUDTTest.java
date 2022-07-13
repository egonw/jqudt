/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.eclipse.rdf4j.model.URI;
import org.eclipse.rdf4j.rio.RDFParseException;

public class QUDTTest {

	@Test
	public void testUnitOntology() throws RDFParseException, IOException {
		URI symbol = QUDT.SYMBOL;
		Assert.assertEquals(QUDT.namespace, symbol.getNamespace());
		Assert.assertEquals("symbol", symbol.getLocalName());
	}

}
