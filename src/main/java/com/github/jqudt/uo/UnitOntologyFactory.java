/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.uo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class UnitOntologyFactory {
	
	private static UnitOntologyFactory factory = null;

	@SuppressWarnings("serial")
	private Map<String,String> uo2qudt = new HashMap<String, String>() {
		// a helper method
	    String longURI(String shortened) {
	    	if (shortened.startsWith("uo:")) return "http://purl.obolibrary.org/obo/" + shortened.substring(3);
	    	if (shortened.startsWith("ops:")) return "http://www.openphacts.org/units/" + shortened.substring(4);
	    	return null;
	    }
	    // the next defines all mappings from the Unit Ontology to the QUDT
	    {		
		    put(longURI("uo:UO_0000065"), longURI("ops:Nanomolar"));
		    put(longURI("uo:UO_0000064"), longURI("ops:Micromolar"));
	    }
	};
	private Map<String,String> qudt2uo = null;

	private UnitOntologyFactory() {
		// not backed up by a formal ontology (at this moment; see UnitFactory's constructor)
		// instead, it uses defined mappings in uo2qudt

		// also make the reverse mapping table
		qudt2uo = new HashMap<String, String>();
		for (String keyURI : uo2qudt.keySet()) qudt2uo.put(uo2qudt.get(keyURI), keyURI);
	}

	public static UnitOntologyFactory getInstance() {
		if (factory == null) factory = new UnitOntologyFactory();
		return factory;
	}

	private static URI asURI(String resource) {
		try {
			return new URI(resource);
		} catch (URISyntaxException exception) {
			return null;
		}
	}

	public Unit getUnit(String resource) {
		System.out.println("resource:" + resource);
		return getUnit(asURI(resource));
	}

	public Unit getUnit(URI resource) {
		if (resource == null) throw new IllegalArgumentException("The URI cannot be null");

		URI mappedURI = asURI(uo2qudt.get(resource.toString()));
		if (mappedURI != null) {
			return UnitFactory.getInstance().getUnit(mappedURI);
		} else {
			return null;
		}
	}

	public List<String> getURIs(String type) {
		URI uri;
		try {
			uri = new URI(type);
		} catch (URISyntaxException exception) {
			throw new IllegalStateException("Invalid URI: " + type, exception);
		}
		return getURIs(uri);
	}
	
	public List<String> getURIs(URI type) {
		List<String> uris = new ArrayList<String>();

		List<String> qudtURIs = UnitFactory.getInstance().getURIs(type);
		for (String qudtString : qudtURIs) {
			String uoURI = qudt2uo.get(qudtString);
			if (uoURI != null) uris.add(uoURI);
		}
		return uris;
	}
}
