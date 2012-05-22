/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.io.IOException;
import java.io.InputStream;

import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;
import org.openrdf.sail.memory.MemoryStore;

public class OntoReader {

	public static Repository read(String ontology) throws RepositoryException, RDFParseException, IOException {
		Repository repos = new SailRepository(new MemoryStore());
		repos.initialize();
		RepositoryConnection con = repos.getConnection();

		String filename = "onto/" + ontology;
        InputStream ins = OntoReader.class.getClassLoader().getResourceAsStream(filename);
		con.add(ins, "", RDFFormat.RDFXML);

		return repos;
	}
}
