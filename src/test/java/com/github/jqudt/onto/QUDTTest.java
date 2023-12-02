/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.io.IOException;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.junit.Assert;
import org.junit.Test;

public class QUDTTest {

	@Test
	public void testUnitOntology() throws RDFParseException, IOException {
		IRI symbol = QUDT.SYMBOL;
		Assert.assertEquals(QUDT.namespace, symbol.getNamespace());
		Assert.assertEquals("symbol", symbol.getLocalName());
	}

}
