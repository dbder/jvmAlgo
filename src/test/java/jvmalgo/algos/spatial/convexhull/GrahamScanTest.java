package jvmalgo.algos.spatial.convexhull;


import jvmalgo.algos.spatial.convexhull.GrahamScan.Vector2;
import jvmalgo.global.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Stream.generate;

public class GrahamScanTest {


    public static void main(String[] args) {
        var dlist = generate(
                () -> Vector2.of(Global.RND.nextFloat() * 1000, Global.RND.nextFloat() * 1000))
                .limit(1000)
                .collect(Collectors.toList());


        SwingUtilities.invokeLater(() -> {

            LineComponent lineComponent = new LineComponent(1000, 1000);
            var hull = GrahamScan.algo.apply(dlist);
            dlist.forEach(lineComponent::addDot);

            for (int i = 1; i < hull.size(); i++) {
                lineComponent.addLine(hull.get(i), hull.get(i - 1));
            }
            lineComponent.addLine(hull.get(0), hull.get(hull.size() - 1));

            JOptionPane.showMessageDialog(null, lineComponent);
        });
    }
}

class LineComponent extends JComponent {
    ArrayList<Line2D.Float> lines = new ArrayList<>();
    ArrayList<Vector2> dots = new ArrayList<>();

    LineComponent(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    public void addDot(Vector2 dot) {
        dots.add(dot);
    }

    public void addLine(Vector2 a, Vector2 b) {
        lines.add(new Line2D.Float(a.x(), a.y(), b.x(), b.y()));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        for (Line2D.Float line : lines) {
            g.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(), (int) line.getY2());
        }

        for (var dot : dots) {
            g.drawOval((int) dot.x() - 2, (int) dot.y() - 2, 5, 5);
        }
    }
}
