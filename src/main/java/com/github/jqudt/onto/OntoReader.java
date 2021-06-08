/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.openrdf.model.Model;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.Rio;

public class OntoReader {

	protected static void read(Model repos, String ontology)
			throws RDFParseException, IOException {
		String filename = "onto/" + ontology;
		InputStream ins = OntoReader.class.getClassLoader()
				.getResourceAsStream(filename);
		if (ontology.endsWith(".ttl")) {
			repos.addAll(Rio.parse(correctXml(ins), "",
                                Rio.getParserFormatForFileName(ontology, RDFFormat.TURTLE)));
		} else {
			repos.addAll(Rio.parse(correctXml(ins), "",
				Rio.getParserFormatForFileName(ontology, RDFFormat.RDFXML)));
		}
	}

	private static InputStream correctXml(InputStream ins) throws IOException {
		StringWriter stringWriter = new StringWriter();
		IOUtils.copy(ins, stringWriter, "UTF-8");
		String insString = stringWriter.toString();
		String re = "[^\\x09\\x0A\\x0D\\x20-\\uD7FF\\uE000-\\uFFFD\\u10000-\\u10FFFF]";
		Pattern pattern = Pattern.compile(re);
		String corrected = pattern.matcher(insString).replaceAll("");
		InputStream inputStream = new ByteArrayInputStream(corrected.getBytes("UTF-8"));
		return  inputStream;
	}
}
