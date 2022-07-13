/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.rio.Rio;

public class OntoReader {

	protected static void read(Model repos, String ontology)
			throws RDFParseException, IOException {
		String filename = "onto/" + ontology;
		InputStream ins = OntoReader.class.getClassLoader()
				.getResourceAsStream(filename);
		if (ontology.endsWith(".ttl")) {
			repos.addAll(Rio.parse(ins, "", RDFFormat.TURTLE));
		} else {
			repos.addAll(Rio.parse(ins, "", RDFFormat.RDFXML));
		}
	}
}
