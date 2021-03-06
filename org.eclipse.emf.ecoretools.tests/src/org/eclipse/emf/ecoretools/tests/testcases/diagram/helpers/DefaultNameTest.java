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
 * $Id: DefaultNameTest.java,v 1.3 2008/05/27 09:54:58 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tests.testcases.diagram.helpers;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackage2EditPart;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.emf.ecoretools.tests.diagram.ui.core.test.AbstractTestBase;
import org.eclipse.emf.ecoretools.tests.testcases.diagram.fixture.EmptyEcoreDiagramTestFixture;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * @author Simon Bernard
 */
public class DefaultNameTest extends AbstractTestBase {

	public DefaultNameTest(String name) {
		super(name);
	}

	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(DefaultNameTest.class);
	}

	protected void setTestFixture() {
		testFixture = new EmptyEcoreDiagramTestFixture();
	}

	protected EmptyEcoreDiagramTestFixture getFixture() {
		return (EmptyEcoreDiagramTestFixture) testFixture;
	}

	/**
	 * Test EPackage default name attribution
	 */
	public void testEPackageDefaultName() throws Exception {

		final DiagramEditPart diagramEP = getFixture().getDiagramEditPart();
		assertTrue(diagramEP.getChildren().isEmpty());

		// Add two EPackage
		EPackage2EditPart epackage1 = (EPackage2EditPart) getFixture().createShapeUsingTool(EcoreElementTypes.EPackage_1002, new Point(10, 10));

		EPackage2EditPart epackage2 = (EPackage2EditPart) getFixture().createShapeUsingTool(EcoreElementTypes.EPackage_1002, new Point(100, 100));

		// check is name are different
		assertFalse(((EPackage) epackage1.resolveSemanticElement()).getName().equals(((EPackage) epackage2.resolveSemanticElement()).getName()));
	}

	/**
	 * Test EPackage default name attribution
	 */
	public void testEAnnotationDefaultName() throws Exception {

		final DiagramEditPart diagramEP = getFixture().getDiagramEditPart();
		assertTrue(diagramEP.getChildren().isEmpty());

		// Add two EPackage
		EAnnotationEditPart eAnnotationEditPart1 = (EAnnotationEditPart) getFixture().createShapeUsingTool(EcoreElementTypes.EAnnotation_1003, new Point(10, 10));

		EAnnotationEditPart eAnnotationEditPart2 = (EAnnotationEditPart) getFixture().createShapeUsingTool(EcoreElementTypes.EAnnotation_1003, new Point(100, 100));

		// check is name are different
		assertFalse(((EAnnotation) eAnnotationEditPart1.resolveSemanticElement()).getSource().equals(((EAnnotation) eAnnotationEditPart2.resolveSemanticElement()).getSource()));
	}
}