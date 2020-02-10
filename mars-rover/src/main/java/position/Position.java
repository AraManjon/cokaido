package position;

import orientation.*;

import java.util.Objects;

public class Position {

    private Orientation orientation;
    private int latitude;
    private int longitude;

    public Position(int latitude, int longitude, char orientation) {

        this.latitude = latitude;
        this.longitude = longitude;
        this.orientation = Orientation.create(orientation);
    }

    public void rotateLeft() {
        this.orientation = orientation.rotateLeft();
    }

    public void rotateRight() {
        this.orientation = orientation.rotateRight();
    }

    public void moveForward() {
        if (orientation instanceof North) longitude++;
        if (orientation instanceof East) latitude++;
        if (orientation instanceof South) longitude--;
        if (orientation instanceof West) latitude--;
    }

    public void moveBackwards() {
        if (orientation instanceof North) longitude--;
        if (orientation instanceof East) latitude--;
        if (orientation instanceof South) longitude++;
        if (orientation instanceof West) latitude++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return latitude == position.latitude &&
                longitude == position.longitude &&
                position.orientation.getClass() == this.orientation.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, latitude, longitude);
    }
}