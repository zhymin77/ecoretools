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
 * $Id: FilteredDiagramContributionItemProvider.java,v 1.3 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.providers;

import org.eclipse.emf.ecoretools.filters.internal.actions.ApplyFilterDiagramAction;
import org.eclipse.emf.ecoretools.filters.internal.actions.DiagramFilterActionMenu;
import org.eclipse.emf.ecoretools.filters.internal.actions.HideInheritanceTypeAction;
import org.eclipse.emf.ecoretools.filters.internal.actions.HideReferenceTypeAction;
import org.eclipse.emf.ecoretools.filters.internal.actions.HideSelectionAction;
import org.eclipse.emf.ecoretools.filters.internal.actions.HideSemanticAction;
import org.eclipse.emf.ecoretools.filters.internal.actions.HideTypeAction;
import org.eclipse.emf.ecoretools.filters.internal.actions.ShowHiddenPartAction;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 13 nov. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class FilteredDiagramContributionItemProvider extends AbstractContributionItemProvider {

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createAction(java.lang.String,
	 *      org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if (actionId.equals(DiagramFilterActionMenu.ID)) {
			return new DiagramFilterActionMenu();
		}
		if (actionId.equals(ApplyFilterDiagramAction.ID)) {
			return new ApplyFilterDiagramAction();
		}
		if (actionId.equals(HideSelectionAction.ID)) {
			return new HideSelectionAction();
		}
		if (actionId.equals(HideTypeAction.ID)) {
			return new HideTypeAction();
		}
		if (actionId.equals(HideSemanticAction.ID)) {
			return new HideSemanticAction();
		}
		if (actionId.equals(ShowHiddenPartAction.ID)) {
			return new ShowHiddenPartAction();
		}
		if (actionId.equals(HideInheritanceTypeAction.ID)) {
			return new HideInheritanceTypeAction();
		}
		if (actionId.equals(HideReferenceTypeAction.ID)) {
			return new HideReferenceTypeAction();
		}

		return super.createAction(actionId, partDescriptor);
	}
}
