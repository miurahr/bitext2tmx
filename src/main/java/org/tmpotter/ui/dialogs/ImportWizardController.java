/* *************************************************************************
 *
 *  TMPotter - Bi-text Aligner/TMX Editor
 *
 *  Copyright (C) 2016 Hiroshi Miura
 *
 *  This file is part of TMPotter.
 *
 *  TMPotter is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  TMPotter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with TMPotter.  If not, see http://www.gnu.org/licenses/.
 *
 * *************************************************************************/

package org.tmpotter.ui.dialogs;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static org.tmpotter.util.Localization.getString;


/**
 *
 * @author Hiroshi Miura
 */
public class ImportWizardController {

	private ImportWizard wizard;
	private ImportPreference pref;
	private boolean finished = false;

	protected File userPathFile = new File(System.getProperty("user.dir"));

	public ImportWizardController(final ImportWizard wizard) {
		this.wizard = wizard;
		pref = wizard.getPref();
		// TODO: get wizards from parameter or manifest.
		registerPanels();
		onStartup();
	}

	private final void registerPanels() {
		wizard.registerWizardPanel(ImportWizardPOFile.id, new ImportWizardPOFile(this, pref));
		wizard.registerWizardPanel(ImportWizardBiTextFile.id, new ImportWizardBiTextFile(this, pref));
		wizard.registerWizardPanel(ImportWizardSelectTypePanel.id, new ImportWizardSelectTypePanel());
	}

	public final void onStartup() {
		wizard.setButtonBackEnabled(false);
		wizard.setButtonNextEnabled(true);
		wizard.showPanel(ImportWizardSelectTypePanel.id);
	}

	public final String getSourceLocale() {
		return pref.getOriginalLang();
	}

	public final String getTargetLocale() {
		return pref.getTranslationLang();
	}

	public final File getSourcePath() {
		return pref.getOriginalFilePath();
	}

	public final File getTargetPath() {
		return pref.getTranslationFilePath();
	}
	
	public final void finish() {
		finished = true;
	}
	
	public final void setButtonNextEnabled(boolean b) {
		wizard.setButtonNextEnabled(b);
	}
	
	public final boolean isFinished() {
		return finished;
	}
	
	public void onBack() {
		String command = wizard.getButtonBackCommand();
		wizard.showPanel(command);
		if (command.equals(ImportWizardSelectTypePanel.id)) {
			wizard.setButtonBackEnabled(false);
		}
	}

	public void onNextFinish() {
		String command = wizard.getButtonNextCommand();
		if ("finish".equals(command)) {
			finish();
			wizard.dispose();
		} else {
			wizard.showPanel(command);
			wizard.setButtonBackEnabled(true);
		}
	}

	public void onCancel() {	
		wizard.dispose();
	}
}
