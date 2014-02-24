/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openrdf.model.Model;
import org.openrdf.model.impl.LinkedHashModel;
import org.openrdf.rio.RDFParseException;

public class OntoReaderTest {

	@Test
	public void testUnitOntology() throws RDFParseException, IOException {
		Model repos = new LinkedHashModel();
		OntoReader.read(repos, "unit");
		Assert.assertNotNull(repos);
	}

}
