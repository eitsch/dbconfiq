package eitsch.dbtool.dbconfiq.gui;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eitsch.dbtool.dbconfiq.model.HudElement;
import eitsch.dbtool.dbconfiq.parser.ShooterUIParser;

/**
 * Simple test of functionality. Also proof of concept for launch4j
 * @author eitsch
 *
 */
public class ApplicationWindow {

	private static final Logger log = LoggerFactory.getLogger(ApplicationWindow.class);

	protected Shell shlDbconfiq;
	private Text txtConsole;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationWindow window = new ApplicationWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlDbconfiq.open();
		shlDbconfiq.layout();
		while (!shlDbconfiq.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDbconfiq = new Shell();
		shlDbconfiq.setSize(450, 300);
		shlDbconfiq.setText("db-confiq");
		shlDbconfiq.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shlDbconfiq, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		composite_1.setLayout(new GridLayout(1, false));
		
		Button btnSetDirectory = new Button(composite_1, SWT.NONE);
		btnSetDirectory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String userhome = System.getProperty("user.home");
				String shooterConfig = userhome + "\\Documents\\My Games\\UnrealEngine3\\ShooterGame\\Config\\ShooterUI.ini";
				DirectoryDialog dialog = new DirectoryDialog(shlDbconfiq);
			    dialog.setFilterPath(userhome + "\\Documents\\My Games\\UnrealEngine3\\ShooterGame\\Config\\"); // Windows specific
			    String dbconfigPath = dialog.open();
			    log.debug("DB-Configpath set to: " + dbconfigPath);
			    ApplicationWindow.this.txtConsole.setText(dbconfigPath);
			    Path path = FileSystems.getDefault().getPath(dbconfigPath);
    		   try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
    		       for (Path entry: stream) {
    		    	   String logmsg = "Config found: " + entry.getFileName().toString(); 
    		    	   log.debug(logmsg);
    		    	   ApplicationWindow.this.txtConsole.append("\r\n" + logmsg);
    		    	   if("ShooterUI.ini".equalsIgnoreCase(entry.getFileName().toString())){
    		    		   log.debug("we have a shooter!");
    		    		   log.debug("absolute path: " + entry.toAbsolutePath().toString());
    		    		   ShooterUIParser parser = new ShooterUIParser(entry);
    		    		   Map<String, HudElement> map = parser.getHudElementsMappedByString();
    		    		   for (Entry<String, HudElement> mapentry : map.entrySet()) {
							String msg = String.format("%s -- %s", mapentry.getKey(), mapentry.getValue());
							log.debug(msg);
							ApplicationWindow.this.txtConsole.append("\r\n" + msg);
						}
    		    				   
    		    	   }
    		       }
    		   } catch (IOException e1) {
				e1.printStackTrace();
			}

			}
		});
		btnSetDirectory.setText("Set Directory");
		
		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setLayout(new GridLayout(1, false));
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		txtConsole = new Text(composite_2, SWT.LEFT|SWT.MULTI);
		GridData gd_txtDsfsdf = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_txtDsfsdf.heightHint = 96;
		txtConsole.setLayoutData(gd_txtDsfsdf);
		txtConsole.setText(" dsfsdf");
		txtConsole.setLayoutData(gd_txtDsfsdf);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}
}
