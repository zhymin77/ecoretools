/***********************************************************************
 * Copyright (c) 2007, 2009 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EClassEditPart.java,v 1.12 2009/04/20 15:08:17 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.diagram.edit.figures.AlphaDropShadowBorder;
import org.eclipse.emf.ecoretools.diagram.edit.figures.FigureFromLabelUtils;
import org.eclipse.emf.ecoretools.diagram.edit.figures.GradientRectangleFigure;
import org.eclipse.emf.ecoretools.diagram.edit.figures.ToolbarLayoutExt;
import org.eclipse.emf.ecoretools.diagram.edit.policies.AlphaResizableShapeEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EClassItemSemanticEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EcoreTextSelectionEditPolicy;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.emf.ecoretools.diagram.preferences.IEcoreToolsPreferenceConstants;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class EClassEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public EClassEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {

			@Override
			public Command getCommand(Request request) {
				if (understandsRequest(request)) {
					if (request instanceof CreateViewAndElementRequest) {
						CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
						IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
						if (type == EcoreElementTypes.EAttribute_2001) {
							EditPart compartmentEditPart = getChildBySemanticHint(EcoreVisualIDRegistry.getType(EClassAttributesEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
						if (type == EcoreElementTypes.EOperation_2002) {
							EditPart compartmentEditPart = getChildBySemanticHint(EcoreVisualIDRegistry.getType(EClassOperationsEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
					}
					return super.getCommand(request);
				}
				return null;
			}
		});

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EClassItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new EcoreTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		ClassFigure figure = new ClassFigure();
		figure.setShouldUseGradient(Boolean.TRUE.equals(getViewer().getProperty(IEcoreToolsPreferenceConstants.PREF_FILL_FIGURE_USING_GRADIENT)));
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ClassFigure getPrimaryShape() {
		return (ClassFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EClassNameEditPart) {
			((EClassNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureClassNameLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EClassNameEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
		AlphaDropShadowBorder shadowBorder = new AlphaDropShadowBorder();
		shadowBorder.setShouldDrawDropShadow(Boolean.TRUE.equals(getViewer().getProperty(IEcoreToolsPreferenceConstants.PREF_USE_SHADOW_ON_BORDER)));
		result.setBorder(shadowBorder);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(getMapMode().DPtoLP(width));
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(EcoreVisualIDRegistry.getType(EClassNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnSource() {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		types.add(EcoreElementTypes.EReference_3002);
		types.add(EcoreElementTypes.EClassESuperTypes_3003);
		return types;
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if (targetEditPart instanceof org.eclipse.emf.ecoretools.diagram.edit.parts.EClassEditPart) {
			types.add(EcoreElementTypes.EReference_3002);
		}
		if (targetEditPart instanceof EDataTypeEditPart) {
			types.add(EcoreElementTypes.EReference_3002);
		}
		if (targetEditPart instanceof EEnumEditPart) {
			types.add(EcoreElementTypes.EReference_3002);
		}
		if (targetEditPart instanceof EClass2EditPart) {
			types.add(EcoreElementTypes.EReference_3002);
		}
		if (targetEditPart instanceof EDataType2EditPart) {
			types.add(EcoreElementTypes.EReference_3002);
		}
		if (targetEditPart instanceof EEnum2EditPart) {
			types.add(EcoreElementTypes.EReference_3002);
		}
		if (targetEditPart instanceof org.eclipse.emf.ecoretools.diagram.edit.parts.EClassEditPart) {
			types.add(EcoreElementTypes.EClassESuperTypes_3003);
		}
		if (targetEditPart instanceof EClass2EditPart) {
			types.add(EcoreElementTypes.EClassESuperTypes_3003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMATypesForTarget(IElementType relationshipType) {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EClass_1001);
		}
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EDataType_1004);
		}
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EEnum_1005);
		}
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EClass_2003);
		}
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EDataType_2004);
		}
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EEnum_2005);
		}
		if (relationshipType == EcoreElementTypes.EClassESuperTypes_3003) {
			types.add(EcoreElementTypes.EClass_1001);
		}
		if (relationshipType == EcoreElementTypes.EClassESuperTypes_3003) {
			types.add(EcoreElementTypes.EClass_2003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnTarget() {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		types.add(EcoreElementTypes.EAnnotationReferences_3001);
		types.add(EcoreElementTypes.EReference_3002);
		types.add(EcoreElementTypes.EClassESuperTypes_3003);
		return types;
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMATypesForSource(IElementType relationshipType) {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EAnnotation_1003);
		}
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EClass_1001);
		}
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EClass_2003);
		}
		if (relationshipType == EcoreElementTypes.EClassESuperTypes_3003) {
			types.add(EcoreElementTypes.EClass_1001);
		}
		if (relationshipType == EcoreElementTypes.EClassESuperTypes_3003) {
			types.add(EcoreElementTypes.EClass_2003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == EcoreElementTypes.EAttribute_2001) {
				return getChildBySemanticHint(EcoreVisualIDRegistry.getType(EClassAttributesEditPart.VISUAL_ID));
			}
			if (type == EcoreElementTypes.EOperation_2002) {
				return getChildBySemanticHint(EcoreVisualIDRegistry.getType(EClassOperationsEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() == getModel() && EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}

	@Override
	protected void refreshVisuals() {
		EObject semanticElement = resolveSemanticElement();
		if (FigureFromLabelUtils.needFromLabel(semanticElement, getNotationView())) {
			getPrimaryShape().updateFromLabel(FigureFromLabelUtils.getQualifiedName(semanticElement));
			getPrimaryShape().addFromLabel();
		} else {
			getPrimaryShape().removeFromLabel();
		}
		super.refreshVisuals();
	}

	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		return new AlphaResizableShapeEditPolicy();
	}

	/**
	 * @generated NOT
	 */
	public class ClassFigure extends GradientRectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureClassNameLabel;

		/**
		 * @generated NOT
		 */
		public ClassFigure() {

			ToolbarLayoutExt layoutThis = new ToolbarLayoutExt();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			layoutThis.setExpandLastItemMajorAxis(true);
			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(30)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureClassNameLabel = new WrappingLabel();
			fFigureClassNameLabel.setAlignment(PositionConstants.TOP);
			fFigureClassNameLabel.setText("<..>"); //$NON-NLS-1$

			this.add(fFigureClassNameLabel);

			fFigureFromLabel = new WrappingLabel();
			fFigureFromLabel.setAlignment(PositionConstants.TOP);
			fFigureFromLabel.setText("<..>"); //$NON-NLS-1$
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		private WrappingLabel fFigureFromLabel;

		private boolean canRemovedFromLabel;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureClassNameLabel() {
			return fFigureClassNameLabel;
		}

		public WrappingLabel getFigureFromLabel() {
			return fFigureFromLabel;
		}

		public void addFromLabel() {
			this.add(getFigureFromLabel(), 1);
			canRemovedFromLabel = true;
		}

		public void removeFromLabel() {
			if (canRemovedFromLabel) {
				this.remove(getFigureFromLabel());
				canRemovedFromLabel = false;
			}
		}

		public void updateFromLabel(String text) {
			getFigureFromLabel().setText(text);
		}

	}

}
