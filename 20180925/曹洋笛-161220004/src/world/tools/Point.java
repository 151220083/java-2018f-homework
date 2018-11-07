package world.tools;

/* �����ͼ�ϵĵ�(row, col)���� */

public class Point {

	private int pRow;
	private int pCol;

	public Point(int r, int c) {
		pRow = r;
		pCol = c;
	}
	
	public int row() {
		return pRow;
	}
	
	public int col() {
		return pCol;
	}
	
	public boolean equ(Point p) {
		return ((pRow == p.row()) && (pCol == p.col()));
	}
	
	public boolean in(Point pLU, Point pRD) {
		return ((pRow >= pLU.row()) && (pRow <= pRD.row()) && (pCol >= pLU.col()) && (pCol <= pRD.col()));
	}
	
	public void reset(int r, int c) {
		pRow = r;
		pCol = c;
	}
	
	public void mov(int dr, int dc) {
		pRow += dr;
		pCol += dc;
	}
}
