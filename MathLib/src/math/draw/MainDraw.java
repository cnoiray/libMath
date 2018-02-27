package math.draw;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainDraw extends JFrame {

private static final long serialVersionUID = -4279980985104445611L;

public MainDraw() {
    setLayout(new BorderLayout());
    add(new DrawFunction(), BorderLayout.CENTER);
}

public static void main(String[] args) {
	MainDraw frame = new MainDraw();
    frame.setSize(800, 500);
    frame.setTitle("Affichage fonction");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

}

class DrawFunction extends JPanel {

	private static final long serialVersionUID = 100L;
	private ComplexCourbe courbe;
	
	public DrawFunction() {
		
		List<String> listeFonction = new ArrayList<>();
//		listeFonction.add("sin(x)");
//		listeFonction.add("cos(x)");
//		listeFonction.add("1*x^0+2*x^1+1*x^2");
//		listeFonction.add("-1*x^0+(-6)*x^1+3*x^2");
//		listeFonction.add("2*x^0+-1*x^1+(-3)*x^2+1*x^3");
//		listeFonction.add("2*x^0+2*x^1+-0.5*x^2+(-1)*x^3+0.25*x^4");
		
//		listeFonction.add("(-8.0)*x^0 +10.0*x^1 +(-1.0)*x^2 +(-1.0)*x^3");
//		listeFonction.add("10.0*x^0 +(-2.0)*x^1 +(-3.0)*x^2");
		
		listeFonction.add("(-8.0)*x^0 +10.0*x^1 +(-3.0)*x^2");
		listeFonction.add("4.0*x^0 +(-8.0)*x^1 +5.0*x^2 +(-1.0)*x^3");
		
		//courbe d'affichage
		courbe = new ComplexCourbe("Resultat étude polynome", "x", "y", listeFonction );
		
		this.add(courbe.getChartPanel());
	}
 }
}