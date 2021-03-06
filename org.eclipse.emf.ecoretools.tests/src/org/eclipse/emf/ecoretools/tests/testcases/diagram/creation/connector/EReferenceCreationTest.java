/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: EReferenceCreationTest.java,v 1.3 2008/05/27 09:54:58 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tests.testcases.diagram.creation.connector;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceEditPart;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.emf.ecoretools.tests.diagram.ui.core.test.AbstractTestBase;
import org.eclipse.emf.ecoretools.tests.testcases.diagram.creation.shape.EPackageCreationTest;
import org.eclipse.emf.ecoretools.tests.testcases.diagram.fixture.EmptyEcoreDiagramTestFixture;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * @author Simon Bernard
 */
public class EReferenceCreationTest extends AbstractTestBase {

	public EReferenceCreationTest(String name) {
		super(name);
	}

	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(EPackageCreationTest.class);
	}

	protected void setTestFixture() {
		testFixture = new EmptyEcoreDiagramTestFixture();
	}

	protected EmptyEcoreDiagramTestFixture getFixture() {
		return (EmptyEcoreDiagramTestFixture) testFixture;
	}

	/**
	 * Test EReference default name attribution
	 */
	public void testEReferenceCreation() throws Exception {

		final DiagramEditPart diagramEP = getFixture().getDiagramEditPart();
		assertTrue(diagramEP.getChildren().isEmpty());

		// add eclass
		EClassEditPart eclass1EditPart = (EClassEditPart) getFixture().createShapeUsingTool(EcoreElementTypes.EClass_1001, new Point(10, 10));
		EClass eclass1 = (EClass) eclass1EditPart.resolveSemanticElement();

		assertEquals(eclass1.eResource(), getFixture().getModelResource());

		// add eclass
		EClassEditPart eclass2EditPart = (EClassEditPart) getFixture().createShapeUsingTool(EcoreElementTypes.EClass_1001, new Point(10, 100));
		EClass eclass2 = (EClass) eclass2EditPart.resolveSemanticElement();

		assertEquals(eclass2.eResource(), getFixture().getModelResource());

		// add ereference
		EReferenceEditPart ereference1EditPart = (EReferenceEditPart) getFixture().createConnectorUsingTool(eclass1EditPart, eclass2EditPart, EcoreElementTypes.EReference_3002);
		EReference ereference1 = (EReference) ereference1EditPart.resolveSemanticElement();

		assertEquals(eclass2.eResource(), getFixture().getModelResource());
		assertTrue(eclass1.getEReferences().contains(ereference1));
	}
}