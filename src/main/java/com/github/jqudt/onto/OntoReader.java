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
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;

public class OntoReader {

	protected static void read(Repository repos, String ontology) throws RepositoryException, RDFParseException, IOException {
		RepositoryConnection con = repos.getConnection();

		String filename = "onto/" + ontology;
        InputStream ins = OntoReader.class.getClassLoader().getResourceAsStream(filename);
        if (ontology.endsWith(".ttl")) {
        	con.add(ins, "", RDFFormat.TURTLE);
        } else {
        	con.add(ins, "", RDFFormat.RDFXML);
        }
	}
}
