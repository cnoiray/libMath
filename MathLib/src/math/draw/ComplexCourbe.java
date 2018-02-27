package math.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import math.main.MainService;

public class ComplexCourbe {
	private ChartPanel chartPanel;

	private String title;

	private String xAxe;

	private String yAxe;
	
	public ComplexCourbe(String title, String xAxe, String yAxe) {
		this.title = title;
		this.xAxe = xAxe;
		this.yAxe = yAxe;
		
		XYDataset dataSet = null;
		
		JFreeChart xylineChart = ChartFactory.createXYLineChart( 
				title , 
				xAxe , 
				yAxe , 
				dataSet, 
				PlotOrientation.VERTICAL , 
				true , 
				true , 
				false ); 
		chartPanel = new ChartPanel( xylineChart ); 
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		chartPanel.setVisible(true);
	}
	
	public ComplexCourbe(String title, String xAxe, String yAxe, List<String> fonction) {
		this.title = title;
		this.xAxe = xAxe;
		this.yAxe = yAxe;
		
		XYDataset dataSet = buildData(fonction);
		
		JFreeChart xylineChart = ChartFactory.createXYLineChart( 
				title , 
				xAxe , 
				yAxe , 
				dataSet, 
				PlotOrientation.VERTICAL , 
				true , 
				true , 
				false );
		
		final XYPlot plot = xylineChart.getXYPlot( );
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );

		BasicStroke tailleLigne = new BasicStroke( 2.0f );
		
		for (int i = 0; i < dataSet.getSeriesCount(); i++) {
			renderer.setSeriesPaint( i , getCouleur(i) );
			renderer.setSeriesStroke( i , tailleLigne );
		}
		
		plot.setRenderer( renderer );
		
		chartPanel = new ChartPanel( xylineChart ); 
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	}
	
	private Paint getCouleur(int i){
		Paint color = Color.BLUE;
		
		switch (i) {
		case 1:
			color = Color.RED;
			break;
		case 2:
			color = Color.GREEN;
			break;
		case 3:
			color = Color.ORANGE;
			break;
		case 4:
			color = Color.BLACK;
			break;
		case 5:
			color = Color.GRAY;
			break;
		case 6:
			color = Color.CYAN;
			break;
		case 7:
			color = Color.MAGENTA;
			break;
		case 8:
			color = Color.PINK;
			break;
		case 9:
			color = Color.YELLOW;
			break;
		case 10:
			color = Color.DARK_GRAY;
			break;
		}
		return color;
	}

	/**
	 * @return the chartPanel
	 */
	public ChartPanel getChartPanel() {
		return chartPanel;
	}

	/**
	 * @param chartPanel the chartPanel to set
	 */
	public void setChartPanel(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}
	
	public XYDataset buildData(List<String> fonction) { 
		final XYSeriesCollection dataset = new XYSeriesCollection( ); 
		int i;
		for (i = 0; i < fonction.size(); i++) {
			XYSeries courbe = new XYSeries( "Courbe: "+fonction.get(i) );
			
			MainService service = new MainService();
			
			List<Coordonnee> coordonnee = service.draw(service.analyse(fonction.get(i)), 0, 3, 20);
			
			for (Coordonnee coordonnee2 : coordonnee) {
				courbe.add(coordonnee2.x,coordonnee2.y);
			}
			
			dataset.addSeries( courbe );
		}
		return dataset; 
    }
}
