/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFParseException;
import org.openrdf.sail.memory.MemoryStore;

public class OntoReaderTest {

	@Test
	public void testUnitOntology() throws RepositoryException, RDFParseException, IOException {
		Repository repos = new SailRepository(new MemoryStore());
		repos.initialize();
		OntoReader.read(repos, "unit");
		Assert.assertNotNull(repos);
	}

}
