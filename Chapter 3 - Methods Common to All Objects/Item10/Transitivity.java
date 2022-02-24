package Item10;

import java.awt.*;
import java.util.Objects;

public class Transitivity
{
}

class Point
{
    private final int x;
    private final int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}

class ColorPoint extends Point
{
    private final Color color;

    public ColorPoint(int x, int y, Color color)
    {
        super(x, y);
        this.color = color;
    }

    // Broken - violates transitivity!
    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof ColorPoint))
            return o.equals(this);

        // o is a ColorPoint; do a full comparison
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}

// Adds a value component without violating the equals contract
class ColorPointWithComposition {
    private final Point point;
    private final Color color;
    
    public ColorPointWithComposition(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }
    
    // Returns the point-view of this color point.
    public Point asPoint() {
        return point;
    }

    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointWithComposition))
            return false;
        ColorPointWithComposition cp = (ColorPointWithComposition) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}