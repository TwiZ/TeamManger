package pl.baranski.teammanager.desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Launches the application GUI.
 *
 * @author Paul Campbell
 */
@Component
public class Runner implements CommandLineRunner {

	/**
	 * Pull in the JFrame to be displayed.
	 */
	@Autowired
	private DemoFrame frame;

	public void run(String... args) throws Exception {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				frame.setVisible(true);
			}
		});
	}

}
