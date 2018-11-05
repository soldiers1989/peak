package com.masspick.peak.diagram;

import org.flowable.image.impl.DefaultProcessDiagramCanvas;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.Paint;
import java.awt.geom.RoundRectangle2D;

/**
 * HMProcessDiagramCanvas
 */
public class HMProcessDiagramCanvas extends DefaultProcessDiagramCanvas {

    /**
     * HIGHLIGHT_COLOR
     */
    private static final Color HIGHLIGHT_COLOR = Color.green;

    /**
     * ARCW
     */
    private static final Double ARCW = 20.0D;

    /**
     * ARCH
     */
    private static final Double ARCH = 20.0D;

    /**
     * @param width
     * @param height
     * @param minX
     * @param minY
     * @param imageType
     * @param activityFontName
     * @param labelFontName
     * @param annotationFontName
     * @param customClassLoader
     */
    public HMProcessDiagramCanvas(int width, int height, int minX, int minY, String imageType,
                                  String activityFontName, String labelFontName, String annotationFontName, ClassLoader customClassLoader) {
        super(width, height, minX, minY, imageType, activityFontName, labelFontName, annotationFontName, customClassLoader);
        initialize(imageType);
    }


    /**
     * @param imageType
     */
    public void initialize(String imageType) {
        super.initialize(imageType);
    }

    /**
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void drawHighLight(int x, int y, int width, int height) {
        Paint originalPaint = g.getPaint();
        Stroke originalStroke = g.getStroke();
        g.setPaint(HIGHLIGHT_COLOR);
        g.setStroke(THICK_TASK_BORDER_STROKE);
        RoundRectangle2D rect = new java.awt.geom.RoundRectangle2D.Double((double) x,
                (double) y, (double) width, (double) height, ARCW, ARCH);
        g.draw(rect);
        g.setPaint(originalPaint);
        g.setStroke(originalStroke);
    }
}
