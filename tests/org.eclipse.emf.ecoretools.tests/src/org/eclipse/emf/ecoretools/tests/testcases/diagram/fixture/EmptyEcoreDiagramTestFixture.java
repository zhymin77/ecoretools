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
 **********************************************************************/

package org.eclipse.emf.ecoretools.tests.testcases.diagram.fixture;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.emf.ecoretools.tests.internal.Activator;
import org.eclipse.emf.ecoretools.tests.testcases.diagram.util.MultiDiagramUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.tests.runtime.diagram.ui.core.fixture.AbstractEmptyDiagramTestFixture;

/**
 * A fixture to make test on a new empty Ecore diagram
 * 
 * @author Simon Bernard
 */
public class EmptyEcoreDiagramTestFixture extends AbstractEmptyDiagramTestFixture {

	/**
	 * @see org.eclipse.gmf.tests.runtime.diagram.ui.core.fixture.AbstractEmptyDiagramTestFixture#createRootModel()
	 */
	public EObject createRootModel() {
		return EcoreFactory.eINSTANCE.createEPackage();
	}

	/**
	 * @see org.eclipse.gmf.tests.runtime.diagram.ui.core.fixture.AbstractEmptyDiagramTestFixture#getDiagramFileCreator()
	 */
	public DiagramFileCreator getDiagramFileCreator() {
		return new EcoreDiagramFileCreator();
	}

	/**
	 * @see org.eclipse.gmf.tests.runtime.diagram.ui.core.fixture.AbstractEmptyDiagramTestFixture#getProjectName()
	 */
	public String getProjectName() {
		return "EcoreToolProj";
	}

	/**
	 * @see org.eclipse.gmf.tests.runtime.diagram.ui.core.fixture.AbstractEmptyDiagramTestFixture#getSemanticResourcePath()
	 */
	public String getSemanticResourcePath() {
		return "EcoreTools";
	}

	/**
	 * @see org.eclipse.gmf.tests.runtime.diagram.ui.core.fixture.AbstractPresentationTestFixture#createShapesAndConnectors()
	 */
	protected void createShapesAndConnectors() throws Exception {
		// Do nothing
	}

	/**
	 * Return the root EPackage
	 * 
	 * @return the root EPackage
	 */
	public EPackage getRootEPackage() {
		return (EPackage) getRootModelEObject();
	}

	/**
	 * @see org.eclipse.gmf.tests.runtime.diagram.ui.core.fixture.AbstractEmptyDiagramTestFixture#getPreferencesHint()
	 */
	public PreferencesHint getPreferencesHint() {
		return new PreferencesHint(EcoreDiagramEditorPlugin.ID);
	}

	/**
	 * Create a diagram in the given editPart
	 * 
	 * @param editPart
	 *            EditPart on which you want create a diagram
	 * @return Diagram the inner Diagram to create
	 */
	public Diagram createInnerDiagram(final EditPart editPart) {
		return createInnerDiagram(editPart, false);
	}

	/**
	 * Create a diagram in the given editPart
	 * 
	 * @param editPart
	 *            EditPart on which you want create a diagram
	 * @param initializedContent
	 *            if true, initialized the content of the diagram with the
	 *            contain of the targetEditPart
	 * @return Diagram the inner Diagram to create
	 */
	public Diagram createInnerDiagram(final EditPart editPart, final boolean initializedContent) {

		execute(new Command() {

			@Override
			public void execute() {
				AbstractEMFOperation operation = new AbstractEMFOperation(getEditingDomain(), "create diagram") { //$NON-NLS-1$

					protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

						result = MultiDiagramUtil.createDiagram(editPart, initializedContent);
						return Status.OK_STATUS;
					}
				};
				try {
					operation.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					Activator.logError("Creation diagram error", e);
				}

			}

			@Override
			public boolean canUndo() {
				return false;
			}
		});
		return result;
	}

	private Diagram result;

	/**
	 * delete the diagram on the given editPart
	 * 
	 * @param diagram
	 * @param editPart
	 */
	public void deleteInnerDiagram(final Diagram diagram, final EditPart editPart) {

		execute(new Command() {

			@Override
			public void execute() {
				AbstractEMFOperation operation = new AbstractEMFOperation(getEditingDomain(), "delete diagram") { //$NON-NLS-1$

					protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

						MultiDiagramUtil.deleteDiagram(diagram, editPart);
						return Status.OK_STATUS;
					}
				};
				try {
					operation.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					Activator.logError("Deletion diagram error", e);
				}
			}

			@Override
			public boolean canUndo() {
				return false;
			}
		});
	}
}