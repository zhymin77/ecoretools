/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EEnumLiterals2CanonicalEditPolicy.java,v 1.2 2008/04/28 08:41:32 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumLiteralEditPart;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramUpdater;
import org.eclipse.emf.ecoretools.diagram.part.EcoreNodeDescriptor;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EEnumLiterals2CanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	@Override
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = EcoreDiagramUpdater.getEEnumLiterals_5008SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((EcoreNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	@Override
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = EcoreVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case EEnumLiteralEditPart.VISUAL_ID:
			return !semanticChildren.contains(view.getElement()) || visualID != EcoreVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement());
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(EcorePackage.eINSTANCE.getEEnum_ELiterals());
		}
		return myFeaturesToSynchronize;
	}

}
