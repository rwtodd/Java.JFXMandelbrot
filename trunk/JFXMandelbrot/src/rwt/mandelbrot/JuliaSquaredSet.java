/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwt.mandelbrot;

/**
 * Implements the class of Julia sets that squares the 
 * accumulator and adds a constant.  x^2 + c
 * @author Richard Todd
 */
final class JuliaSquaredSet implements PixelSupplier {
    final double addX;
    final double addY;
    
    JuliaSquaredSet(double xloc, double yloc) {
        addX = xloc;
        addY = yloc;
    }
    
    @Override
    public int colorPixel(final double x, final double y) {
       int answer = 255;
       double  cx = x;
       double  cy = y;
       while(( cx*cx+cy*cy < 4.0) && (answer > 0)) {
          final double tmp  = cx*cy;
          cx = cx*cx - cy*cy + addX;
          cy = tmp+tmp + addY;
          --answer; 
       }
       return answer; 
    }

}
