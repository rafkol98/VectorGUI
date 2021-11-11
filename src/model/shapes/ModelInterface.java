package model.shapes;

import java.awt.*;

public interface ModelInterface {

    void calculateStartEnd();

    Point getStart();

    Point getEnd();

    Color getColour();

    boolean isFilled();
}
