package model.util;

import java.util.List;
import java.util.Random;

import model.RGBColor;


/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of
 * ways to combine colors, many may exist and we do not want to keep
 * modifying the RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorCombinations
{
    /**
     * Combine two colors by adding their components.
     */
    public static RGBColor add (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() + right.getRed(), 
                            left.getGreen() + right.getGreen(),
                            left.getBlue() + right.getBlue());
    }

    /**
     * Combine two colors by subtracting their components.
     */
    public static RGBColor subtract (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() - right.getRed(), 
                            left.getGreen() - right.getGreen(),
                            left.getBlue() - right.getBlue());
    }

    /**
     * Combine two colors by multiplying their components.
     */
    public static RGBColor multiply (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() * right.getRed(), 
                            left.getGreen() * right.getGreen(),
                            left.getBlue() * right.getBlue());
    }

    /**
     * Combine two colors by dividing their components.
     */
    public static RGBColor divide (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() / right.getRed(), 
                            left.getGreen() / right.getGreen(),
                            left.getBlue() / right.getBlue());
    }
    
    /**
     * Combine two colors by taking the modulus of their components.
     */
    public static RGBColor modulus (RGBColor left, RGBColor right)
    {
    	return new RGBColor(left.getRed() % right.getRed(),
    						left.getGreen() % right.getGreen(),
    						left.getBlue() % right.getBlue());
    }
    
    /**
     * Combine two colors by raising the first to the power of the second.
     */
    public static RGBColor exponent (RGBColor left, RGBColor right){
    	return new RGBColor(Math.pow(left.getRed(),right.getRed()),
    						Math.pow(left.getGreen(),right.getGreen()),
    						Math.pow(left.getBlue(),right.getBlue()));
    }
    
    /**
     * Returns the inverted color given by RGBColor left.
     */
    public static RGBColor negative (RGBColor left){
    	return new RGBColor(left.getRed()*-1,left.getGreen()*-1,left.getBlue()*-1);
    }
    
    /**
     * Returns the absolute values of each component.
     */
    public static RGBColor absolute (RGBColor color){
    	return new RGBColor(Math.abs(color.getRed()),
    						Math.abs(color.getGreen()),
    						Math.abs(color.getBlue()));
    }
    
    /**
     * Returns the sin of each component (converted to radians).
     */
    public static RGBColor sin (RGBColor color){
    	return new RGBColor(Math.sin(color.getRed()*Math.PI),
    						Math.sin(color.getGreen()*Math.PI),
    						Math.sin(color.getBlue()*Math.PI));
    }
    
    /**
     * Returns the sin of each component (converted to radians).
     */
    public static RGBColor cos (RGBColor color){
    	return new RGBColor(Math.cos(color.getRed()*Math.PI),
							Math.cos(color.getGreen()*Math.PI),
							Math.cos(color.getBlue()*Math.PI));
    }
    
    /**
     * Returns the tangent of each component (coverted to radians).
     */
    public static RGBColor tangent (RGBColor color){
    	return new RGBColor(Math.tan(color.getRed()*Math.PI),
							Math.tan(color.getGreen()*Math.PI),
							Math.tan(color.getBlue()*Math.PI));
    }
    
    /**
     * Returns the arctangent of each component (coverted to radians).
     */
    public static RGBColor arcTangent (RGBColor color){
    	return new RGBColor(Math.atan(color.getRed()),
							Math.atan(color.getGreen()),
							Math.atan(color.getBlue()));
    }
    
    /**
     * Returns the logarithm (base e) of each component.
     */
    public static RGBColor logarithm (RGBColor color){
    	return new RGBColor(Math.log(color.getRed()),
							Math.log(color.getGreen()),
							Math.log(color.getBlue()));
    }
    
    public static RGBColor floor (RGBColor color){
    	return new RGBColor(Math.floor(color.getRed()),
    						Math.floor(color.getGreen()),
    						Math.floor(color.getBlue()));
    	
    }
    
    public static RGBColor ceiling (RGBColor color){
    	return new RGBColor (Math.ceil(color.getRed()),
    						 Math.ceil(color.getGreen()),
    						 Math.ceil(color.getBlue()));
	    }
    
    public static RGBColor random (){
    	Random gen = new Random();
    	RGBColor color = new RGBColor(gen.nextGaussian(),gen.nextGaussian(),gen.nextGaussian());
    	return color;
    }
    
    public static RGBColor minimum (RGBColor left, RGBColor right){
    	return new RGBColor (Math.min(left.getRed(), right.getRed()),
    						 Math.min(left.getGreen(), right.getGreen()),
    						 Math.min(left.getBlue(), right.getBlue()));
    }
    
    public static RGBColor maximum (RGBColor left, RGBColor right){
    	return new RGBColor (Math.max(left.getRed(), right.getRed()),
    						 Math.max(left.getGreen(), right.getGreen()),
    						 Math.max(left.getBlue(), right.getBlue()));
    }
    
}
