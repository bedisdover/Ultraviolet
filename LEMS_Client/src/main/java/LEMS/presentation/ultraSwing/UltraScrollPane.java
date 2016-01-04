package LEMS.presentation.ultraSwing;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class UltraScrollPane extends JScrollPane {
	private static final long serialVersionUID = 1L;

	public UltraScrollPane(Component view) {
		super(view);
		init();
	}

	private void init() {
		setOpaque(false);
		getViewport().setOpaque(false);
		setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));

		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		getVerticalScrollBar().setUI(new myScrollBarUI());
		getHorizontalScrollBar().setUI(new myScrollBarUI());
	}

	public class myScrollBarUI extends BasicScrollBarUI {
		// 圆角矩形的弧度
		private static final float ARC_NUMBER = 12.0f;

		@Override
		protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {

			Graphics2D g2 = (Graphics2D) g;
			int w = thumbBounds.width - 1;
			int h = thumbBounds.height - 1;

			// 消除锯齿状边缘
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2.translate(thumbBounds.x, thumbBounds.y);

			Shape arcRect = new RoundRectangle2D.Float(0.0f, 0.0f, (float) w, (float) h, ARC_NUMBER, ARC_NUMBER);
			// 填充滚动条矩形
			Paint arcRectPaint = null;
			if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
				arcRectPaint = new GradientPaint(0, 0, new Color(225, 225, 225), thumbBounds.width, 0,
						new Color(162, 162, 162));
			} else {
				arcRectPaint = new GradientPaint(0, 0, new Color(225, 225, 225), 0, thumbBounds.height,
						new Color(162, 162, 162));
			}
			g2.setPaint(arcRectPaint);
			g2.fill(arcRect);
			// 画滚动条矩形边框
			// g2.setColor(new Color(70, 70, 70));
			// g2.draw(arcRect);
			// 画滚动条矩形内圈边框
			// g2.setColor(new Color(230, 230, 230));
			// Rectangle bounds = arcRect.getBounds();
			// g2.drawRoundRect(bounds.x + 1, bounds.y + 1, bounds.width - 2,
			// bounds.height - 2, (int) ARC_NUMBER, (int) ARC_NUMBER);
			//
			// g2.translate(-thumbBounds.x, -thumbBounds.y);
			// g2.setPaint(oldPaint);
		}

		@Override
		protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
			Graphics2D g2 = (Graphics2D) g;
			Paint foregroundRectPaint = null;
			Paint backgroupRectPaint = null;
			Paint oldPaint = g2.getPaint();
			// 绘制滚动背景
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
				foregroundRectPaint = Color.white;
				backgroupRectPaint = Color.white.darker();
			} else {
				foregroundRectPaint = Color.white.darker();
				backgroupRectPaint = Color.white.darker();
			}
			g2.setPaint(backgroupRectPaint);
			g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
			g2.setPaint(foregroundRectPaint);
			g2.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width - 1, trackBounds.height - 1,
					(int) ARC_NUMBER, (int) ARC_NUMBER);
			g2.setColor(Color.white.darker());
			g2.drawRoundRect(trackBounds.x, trackBounds.y, trackBounds.width - 1, trackBounds.height - 1,
					(int) ARC_NUMBER, (int) ARC_NUMBER);

			g2.setPaint(oldPaint);

			// 始终没有进入这两个判断方法，通过单独调用它们中的任意一个即刻明白这两个方法的含义
			if (trackHighlight == DECREASE_HIGHLIGHT) {
				paintDecreaseHighlight(g);
			} else if (trackHighlight == INCREASE_HIGHLIGHT) {
				paintIncreaseHighlight(g);
			}
		}

		@Override
		protected void paintDecreaseHighlight(Graphics g) {
		}

		@Override
		protected void paintIncreaseHighlight(Graphics g) {
		}

		@Override
		protected javax.swing.JButton createDecreaseButton(int orientation) {
			return new BasicArrowButton(orientation) {

				/*
				 * (non-Javadoc)
				 * 
				 * @see javax.swing.plaf.basic.BasicArrowButton#paint(java.awt.
				 * Graphics)
				 */
				@Override
				public void paint(Graphics g) {
					GradientPaint backgroupRectPaint = null;
					// if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
					// backgroupRectPaint = new GradientPaint(0, 0, new
					// Color(216, 216, 216),
					// getWidth(), 0, new Color(172, 172, 172));
					// } else {
					// backgroupRectPaint = new GradientPaint(0, 0, new
					// Color(216, 216, 216),
					// 0, getHeight(), new Color(172, 172, 172));
					// }
					Graphics2D g2 = (Graphics2D) g;

					g2.setPaint(new Color(130, 130, 130));
					g2.fillRect(0, 0, getWidth(), getHeight());
					// Draw the arrow
					// IScrollBarUI.this.paintTriangle(g2, getSize(),
					// direction);
				}
			};
		}

		@Override
		protected javax.swing.JButton createIncreaseButton(int orientation) {
			return new BasicArrowButton(orientation) {

				/*
				 * (non-Javadoc)
				 * 
				 * @see javax.swing.plaf.basic.BasicArrowButton#paint(java.awt.
				 * Graphics)
				 */
				@Override
				public void paint(Graphics g) {
					GradientPaint backgroupRectPaint = null;
					// if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
					// backgroupRectPaint = new GradientPaint(0, 0, new
					// Color(216, 216, 216),
					// getWidth(), 0, new Color(172, 172, 172));
					// } else {
					// backgroupRectPaint = new GradientPaint(0, 0, new
					// Color(216, 216, 216),
					// 0, getHeight(), new Color(172, 172, 172));
					// }
					Graphics2D g2 = (Graphics2D) g;
					g2.setPaint(new Color(130, 130, 130));
					g2.fillRect(0, 0, getWidth(), getHeight());
					// Draw the arrow
					// IScrollBarUI.this.paintTriangle(g2, getSize(),
					// direction);
				}
			};
		}

	}
}
