package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class DrawFishFood {

		public static void draw(Graphics2D g, int x, int y) {
			// Draw the fish.
			g.setColor(Color.ORANGE);

			Shape food = new Ellipse2D.Double(x - 15, y - 10, 10, 10);

			g.fill(food);
			g.setColor(Color.black);
			g.draw(food);

		}		
	}


