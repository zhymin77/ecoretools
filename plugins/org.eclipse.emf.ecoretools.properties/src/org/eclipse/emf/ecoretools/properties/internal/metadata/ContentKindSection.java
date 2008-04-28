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
 * $Id: ContentKindSection.java,v 1.2 2008/04/28 08:41:44 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.metadata;

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.tabbedproperties.EMFRecordingChangeCommand;
import org.eclipse.emf.tabbedproperties.sections.AbstractTabbedPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * Section to edit content kind extended metadata annotation
 * 
 * @see ExtendedMetaData#setContentKind(EClass, int)
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ContentKindSection extends AbstractTabbedPropertySection {

	/**
	 * A boolean that store if refreshing is happening and no model
	 * modifications should be performed
	 */
	private boolean isRefreshing = false;

	/**
	 * The combo box control for the section.
	 */
	private CCombo contentKindCb;

	/**
	 * The section label;
	 */
	private CLabel labelTxt;

	// /**
	// * @see
	// org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	// org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	// */
	// public void createControls(Composite parent, TabbedPropertySheetPage
	// aTabbedPropertySheetPage)
	// {
	// super.createControls(parent, aTabbedPropertySheetPage);
	// Composite composite = getWidgetFactory().createFlatFormComposite(parent);
	//        
	// String label = getLabelText();
	// labelTxt = getWidgetFactory().createCLabel(composite, label);
	//        
	// contentKindCb = getWidgetFactory().createCCombo(composite, SWT.FLAT |
	// SWT.READ_ONLY | SWT.BORDER);
	//
	// FormData data = new FormData();
	// data.left = new FormAttachment(0, 0);
	// data.right = new FormAttachment(contentKindCb,
	// -ITabbedPropertyConstants.HSPACE);
	// data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
	// labelTxt.setLayoutData(data);
	//        
	// data = new FormData();
	// data.left = new FormAttachment(0, getStandardLabelWidth(composite, new
	// String[] {label}));
	// data.right = new FormAttachment(100, 0);
	// data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
	// contentKindCb.setLayoutData(data);
	//        
	// hookListeners();
	// }

	/**
	 * @see org.eclipse.emf.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createWidgets(Composite composite) {
		labelTxt = getWidgetFactory().createCLabel(composite, getLabelText());

		contentKindCb = getWidgetFactory().createCCombo(composite, SWT.FLAT | SWT.READ_ONLY | SWT.BORDER);
	}

	/**
	 * @see org.eclipse.emf.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(contentKindCb, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelTxt.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] { getLabelText() }));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
		contentKindCb.setLayoutData(data);
	}

	/**
	 * Adds the listeners on the widgets
	 */
	@Override
	protected void hookListeners() {
		contentKindCb.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				handleComboModified();
			}
		});
	}

	/**
	 * Handle the combo modified event.
	 */
	protected void handleComboModified() {
		if (!isRefreshing) {
			final int newContentKind = getIndex(contentKindCb.getText());
			EditingDomain editingDomain = getEditingDomain();
			if (getEObjectList().size() == 1) {
				int oldContentKind = ExtendedMetaData.INSTANCE.getContentKind((EClass) getEObject());
				if (oldContentKind != newContentKind) {
					editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

						@Override
						protected void doExecute() {
							ExtendedMetaData.INSTANCE.setContentKind((EClass) getEObject(), newContentKind);
						}
					});
				}
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (Iterator<EObject> i = getEObjectList().iterator(); i.hasNext();) {
					final EObject nextObject = i.next();

					int oldContentKind = ExtendedMetaData.INSTANCE.getContentKind((EClass) nextObject);
					if (oldContentKind != newContentKind) {
						compoundCommand.append(new EMFRecordingChangeCommand(nextObject.eResource()) {

							@Override
							protected void doExecute() {
								ExtendedMetaData.INSTANCE.setContentKind((EClass) nextObject, newContentKind);
							}
						});
					}
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
		}
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		isRefreshing = true;

		contentKindCb.setItems(ExtendedMetaData.CONTENT_KINDS);
		int contentKind = ExtendedMetaData.INSTANCE.getContentKind((EClass) getEObject());
		contentKindCb.setText(ExtendedMetaData.CONTENT_KINDS[contentKind]);

		isRefreshing = false;
	}

	/**
	 * Gets the respect if index of the key inside this array. It returns -1 when
	 * the key is not find inside the array
	 * 
	 * @param key
	 * @return the key index
	 */
	private int getIndex(String key) {
		String[] contentKinds = ExtendedMetaData.CONTENT_KINDS;
		for (int i = 0; i < contentKinds.length; i++) {
			if (contentKinds[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @see org.eclipse.emf.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return null;
	}

	/**
	 * @see org.eclipse.emf.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return "Content Kind";
	}

}
