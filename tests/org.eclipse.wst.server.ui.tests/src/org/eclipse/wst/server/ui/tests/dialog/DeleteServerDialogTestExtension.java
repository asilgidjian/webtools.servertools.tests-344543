package org.eclipse.wst.server.ui.tests.dialog;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wst.server.ui.internal.DeleteServerDialogExtension;

public class DeleteServerDialogTestExtension extends
		DeleteServerDialogExtension {

	public static final String BUTTON_TEXT = "Just testing";

	public DeleteServerDialogTestExtension() {

	}

	@Override
	public void createControl(Composite parent) {
		Button testButton = new Button(parent, SWT.CHECK);
		testButton.setText(BUTTON_TEXT);
		testButton.setSelection(true);
	}

	@Override
	public void performCustomCleanup(IProgressMonitor monitor) {
		// do nothing

	}

}
